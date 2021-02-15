package com.ApplicationJ.config.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.model.UsersBO;
import com.ApplicationJ.utility.SupportUtility;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		SupportUtility.logger.debug("RequestUri " + request.getRequestURI());
		final String jwtToken = request.getHeader(ApplicationConstants.authKey);
		try {
			UsersBO user = jwtTokenUtil.getUserFromToken(jwtToken);
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
		} catch (Exception e) {
			System.out.println("JWT error=" + e.getMessage());
		}
		chain.doFilter(request, response);
	}

}