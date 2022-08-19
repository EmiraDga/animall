package com.wct.animall.security;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.wct.animall.security.jwt.JwtTokenFilterConfigurer;
import com.wct.animall.security.jwt.JwtTokenProviderService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private String appUri = "localhost:4200";

	private JwtTokenProviderService jwtTokenProviderService;

	public WebSecurityConfiguration(JwtTokenProviderService jwtTokenProviderService) {
		this.jwtTokenProviderService = jwtTokenProviderService;
	}

	@Override
	public void configure(final HttpSecurity http) throws Exception {
		// Added
		var cors = new CorsConfiguration();
		cors.setAllowedOrigins(List.of("http://localhost:4200", "http://127.0.0.1:80", "http://example.com"));
		cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		cors.setAllowedHeaders(List.of("*"));

		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors().and().antMatcher("/**").authorizeRequests() //
				.mvcMatchers("/oauth/authorize").permitAll() //
				.mvcMatchers("/actuator/**").permitAll() //
				.mvcMatchers("/logout").permitAll() //
				.mvcMatchers("/swagger-ui/**").permitAll() //
				.mvcMatchers("/swagger-ui.html").permitAll() //
				.mvcMatchers("/v3/api-docs/**").permitAll().anyRequest().authenticated();

		// Set unauthorized requests exception handler
		http.exceptionHandling().authenticationEntryPoint(
				(request, response, ex) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage()))
				.and();

		// Apply JWT
		http.apply(new JwtTokenFilterConfigurer(jwtTokenProviderService));

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return authenticationManager();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedHeaders(List.of("*"));
		configuration.setAllowedOrigins(List.of(appUri));
		configuration.setAllowedMethods(Arrays.asList("OPTIONS", "GET", "POST", "PUT", "DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
