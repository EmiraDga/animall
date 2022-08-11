package com.wct.animall.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wct.animall.security.JwtTokenFilter;

public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private JwtTokenProviderService jwtTokenProviderService;

	public JwtTokenFilterConfigurer(JwtTokenProviderService jwtTokenProviderService) {
		this.jwtTokenProviderService = jwtTokenProviderService;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new JwtTokenFilter(jwtTokenProviderService), UsernamePasswordAuthenticationFilter.class);
	}
}