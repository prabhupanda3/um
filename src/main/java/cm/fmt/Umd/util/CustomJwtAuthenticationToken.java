package cm.fmt.Umd.util;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

public class CustomJwtAuthenticationToken extends JwtAuthenticationConverter{

	public CustomJwtAuthenticationToken() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
		// TODO Auto-generated method stub
		String claim=jwt.getClaim("roles");
		System.out.println("Role :"+claim);
		if(claim!=null) {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + claim));
		}
		return Collections.emptyList();
	}

	
	

}
