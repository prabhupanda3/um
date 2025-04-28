package cm.fmt.Umd.util;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.fmt.Umd.model.Role;
import com.fmt.Umd.model.SubModule;
import com.fmt.Umd.service.RoleService;
@Component
public class DynamicAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext>{
	@Autowired
	private RoleService roleservice;
    private final AntPathMatcher pathMatcher = new AntPathMatcher();


	@Override
	public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
		// TODO Auto-generated method stub
		
		try {
		 String requestUri=context.getRequest().getRequestURI();
		 System.out.println("Request Uri :"+requestUri);
		 String url[]=requestUri.split("/");
		 String finalUri="/"+url[1]+"/**";
		 System.out.println("Final URI :"+finalUri);
	     List<Role>	roles=roleservice.getAllRoles();
	     Authentication auth = authentication.get();
         Set<String> authorities= auth.getAuthorities().stream()
        		                     .map(grantedAuthority -> grantedAuthority.getAuthority().replace("ROLE_", "")) // remove "ROLE_" prefix
                                     .collect(java.util.stream.Collectors.toSet());
         for(Role role:roles) {
        	 if(authorities.contains(role.getAuthority())) {
        	     Set<com.fmt.Umd.model.Module>	 modules=role.getModule();
        	       for(com.fmt.Umd.model.Module module:modules) {
        	         List<SubModule>	submodules=module.getSubModule();
        	           for(SubModule submodule:submodules) {
        	             String endpoint=submodule.getEndpoint();
        	             System.out.println("End point :"+endpoint);
        	                if(pathMatcher.match(endpoint, finalUri)) {
      		                  System.out.println("==========Accessed==========");

        		                  return new AuthorizationDecision(true);
        	                       }
        	                      }
        	                    }
        	                  }
                            }		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new AuthorizationDecision(false);
	}
	

}
