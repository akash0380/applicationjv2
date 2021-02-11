package com.ApplicationJ.config.security;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.dao.UsersDao;
import com.ApplicationJ.model.UsersBO;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;

	@Value("${jwt.secret}")
	private String secret;

	@Autowired
	private UsersDao userDao;

	public UsersBO getUserFromToken(String accessToken) {
		UsersBO user = null;
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret))
				.parseClaimsJws(accessToken).getBody();
		if (claims.containsKey("user")) {
			ObjectMapper mapper = new ObjectMapper();
			UsersBO userTmp = mapper.convertValue(claims.get("user", LinkedHashMap.class), UsersBO.class);
			Date dt = claims.get("exp", Date.class);
			Optional<UsersBO> userData = userDao.findById(userTmp.getId());
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
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
		Key signKey = new SecretKeySpec(apiKeySecretBytes, algorithm.getJcaName());

		Map<String, Object> userDtoMap = new HashMap<>();
		userDtoMap.put("id", userbo.getId());
		userDtoMap.put("name", userbo.getName());
		userDtoMap.put("email", userbo.getEmail());

		JwtBuilder builder = Jwts.builder().claim("user", userDtoMap).setId(userbo.getId().toString()).setIssuedAt(now)
				.setExpiration(exp).signWith(algorithm, signKey);
		return builder.compact();
	}

}