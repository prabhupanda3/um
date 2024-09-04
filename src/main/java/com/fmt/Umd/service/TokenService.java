package com.fmt.Umd.service;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
	
private JwtEncoder jwtEncoder;

private JwtDecoder jwtDecoder;
	
private UserDetailsServices userDetailsServices;
	
	 
	


public TokenService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, UserDetailsServices userDetailsServices) {
	
	this.jwtEncoder = jwtEncoder;
	this.jwtDecoder = jwtDecoder;
	this.userDetailsServices = userDetailsServices;
}

public String getGenratedToken(Authentication authentication) {
	try {
		Instant now=	Instant.now();
		
	String	scope=authentication
			.getAuthorities()
			.stream()
			.map(GrantedAuthority::getAuthority)
			.collect(Collectors.joining(" "));
	JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
			.issuer("self")
			.issuedAt(now)
			.subject(authentication.getName())
			.claim("roles",scope).build();

	return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
}catch(Exception ex) {
	return "Token not generated";
}
	
}




}
