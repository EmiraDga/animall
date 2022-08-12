package com.wct.animall.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wct.animall.exception.ResourceNotFoundException;
import com.wct.animall.security.jwt.JwtTokenProviderService;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProviderService jwtTokenProviderService;

	public JwtTokenFilter(JwtTokenProviderService jwtTokenProviderService) {
		this.jwtTokenProviderService = jwtTokenProviderService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		String token = jwtTokenProviderService.parseToken(httpServletRequest);
		try {
			if (token != null && jwtTokenProviderService.validateToken(token)) {
				var auth = jwtTokenProviderService.validateUserAndGetAuthentication(token);
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (ResourceNotFoundException ex) {
			SecurityContextHolder.clearContext();
			return;
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

}
