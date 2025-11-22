package com.ApplicationJ.config.security;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.dao.UsersDao;
import com.ApplicationJ.model.UsersBO;
import com.ApplicationJ.utility.SupportUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private UsersDao usersDao;
	
	@Value("${jwt.secret}")
	private String secret;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		SupportUtility.logger.debug("RequestUri " + request.getRequestURI());
		final String jwtToken = request.getHeader(ApplicationConstants.authKey);
		UsersBO user = null;
		try {
			user = getUserFromToken(jwtToken);
		} catch (Exception e) {
			SupportUtility.logger.debug("JWT Error " + e.getMessage());
		}
		if (user != null) {
			if (user.getUsername() != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
						user.getPassword(), new ArrayList<>());
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		chain.doFilter(request, response);
	}
	
	public UsersBO getUserFromToken(String accessToken) {
		UsersBO user = null;
		Claims claims = Jwts.parser().setSigningKey(Base64.getDecoder().decode(secret))
			.parseClaimsJws(accessToken).getBody();
		if (claims.containsKey(ApplicationConstants.mapKey)) {
			ObjectMapper mapper = new ObjectMapper();
			UsersBO userTmp = mapper.convertValue(claims.get(ApplicationConstants.mapKey, LinkedHashMap.class), UsersBO.class);
			Optional<UsersBO> userData = usersDao.findById(userTmp.getId());
			if (userData.isPresent()) {
				user=userData.get();
			}
		}
		return user;
	}

	public String generateToken(UsersBO userbo) {
		SignatureAlgorithm algorithm = SignatureAlgorithm.HS512;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		Date exp = new Date(now.getTime() + TimeUnit.HOURS.toMillis(ApplicationConstants.expInHr));
		byte[] apiKeySecretBytes = Base64.getDecoder().decode(secret);
		Key signKey = new SecretKeySpec(apiKeySecretBytes, algorithm.getJcaName());

		Map<String, Object> userDtoMap = new HashMap<>();
		userDtoMap.put("id", userbo.getId());
		userDtoMap.put("role", userbo.getRole().getRole_id());

		JwtBuilder builder = Jwts.builder().claim(ApplicationConstants.mapKey, userDtoMap).setId(userbo.getId().toString()).setIssuedAt(now)
				.setExpiration(exp).signWith(algorithm, signKey);
		return builder.compact();
	}

}