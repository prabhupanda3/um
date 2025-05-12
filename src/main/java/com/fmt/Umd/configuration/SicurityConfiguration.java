package com.fmt.Umd.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import com.fmt.Umd.model.Module;
import com.fmt.Umd.model.SubModule;
import com.fmt.Umd.service.RoleService;
import com.fmt.Umd.service.UserDetailsServices;
import com.fmt.Umd.user.model.Role;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import cm.fmt.Umd.util.DynamicAuthorizationManager;
import cm.fmt.Umd.util.RSAKeyProperties;

@Configuration
@ComponentScan(basePackages = {"cm.fmt.Umd.util"})
public class SicurityConfiguration {

	private  RSAKeyProperties rSAKeyProperties;
	private  UserDetailsServices userDetailsServices;
	@Autowired
	private RoleService roleService;
	@Autowired
	public SicurityConfiguration(RSAKeyProperties rSAKeyProperties,UserDetailsServices userDetailsServices) {
		this.rSAKeyProperties=rSAKeyProperties;
		this.userDetailsServices=userDetailsServices;
		
	}
	@Bean 
    public JwtEncoder jwtEncoder() {	
	JWK jwk=new RSAKey.Builder(rSAKeyProperties.getPublicKey()).privateKey(rSAKeyProperties.getPrivateKey()).build();
    JWKSource<SecurityContext> jwksource=new ImmutableJWKSet<>(new JWKSet(jwk));
    return new NimbusJwtEncoder(jwksource);
    }
	 @Bean
	    public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(rSAKeyProperties.getPublicKey()).build();
	    }
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    public AuthenticationManager authManager(UserDetailsService userDetailsService) {
	DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	daoAuthenticationProvider.setUserDetailsService(userDetailsService);
	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	return new ProviderManager(daoAuthenticationProvider);
     }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,DynamicAuthorizationManager dynamicAuthManager) throws Exception{
	http.csrf(csrf->csrf.disable()).cors().and().authorizeHttpRequests(auth->{
		
		auth.mvcMatchers("/auth/**").permitAll()
		.anyRequest().access(dynamicAuthManager);
	  
       });
	http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());
	http.sessionManagement(seession->seession.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	return http.build();
    }
   
 
	  @Bean public JwtAuthenticationConverter jwtAuthenticationConverter() {
	  JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter=new
	  JwtGrantedAuthoritiesConverter();
	  jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
	  jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
	  JwtAuthenticationConverter jwtAuthenticationConverter= new
	  JwtAuthenticationConverter();
	  jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(
	  jwtGrantedAuthoritiesConverter); return jwtAuthenticationConverter; }
	  

}
