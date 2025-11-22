package com.ApplicationJ.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import jakarta.annotation.PostConstruct;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.utility.SupportUtility;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig implements UserDetailsService {

	@Autowired
	private TokenAuthEntryPoint tokenAuthEntryPoint;

	@Autowired
	private SecurityFilter securityFilter;

	@Autowired
	SupportUtility supportUtility;

	@Value("${application_security_flag}")
	private boolean application_security_flag;

	private String[] pathArray = null;

	@PostConstruct
	public void init() {
		if (application_security_flag) {
			pathArray = new String[] { "/auth/token", "/welcome/checkactiveprofile", "/users/add", "/users/login", "/swagger-ui.html", "/webjars/**",
					"/v2/**", "/swagger-resources/**" };
		} else {
			pathArray = new String[] { "/**" };
		}
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		if (pathArray != null) {
			http.authorizeHttpRequests(authorize -> authorize
					.requestMatchers(pathArray).permitAll()
					.anyRequest().authenticated());
		} else {
			http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());
		}
		http.exceptionHandling(ex -> ex.authenticationEntryPoint(tokenAuthEntryPoint))
				.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return this;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		throw new UsernameNotFoundException("UserDetailsService not implemented");
	}
}