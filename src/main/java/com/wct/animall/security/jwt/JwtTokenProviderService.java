package com.wct.animall.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.wct.animall.exception.ResourceNotFoundException;
import com.wct.animall.model.Authority;
import com.wct.animall.security.service.MyUserDetailsService;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenProviderService {

	private String secretKey = "09-08-2022-api";

	@Value("${springboot.app.jwtExpirationMs}")
	private Long expiration;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public JwtTokenProviderService(MyUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public String createToken(String userName, Authority role) {
		var claims = Jwts.claims().setSubject(userName);
		claims.put("auth", List.of(role.getAuthority()).stream().map(SimpleGrantedAuthority::new)
				.filter(Objects::nonNull).collect(Collectors.toList()));
		var validity = new Date(System.currentTimeMillis() + expiration);
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date()).setExpiration(validity)
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	public Authentication validateUserAndGetAuthentication(String token) {
		var userDetails = userDetailsService.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "",
				((AbstractAuthenticationToken) userDetails).getAuthorities());
	}

	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public String parseToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

	public boolean validateToken(String token) throws ResourceNotFoundException {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			throw new ResourceNotFoundException("Expired or invalid JWT token");
		}
	}

}
