package com.fmt.Umd.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.Dto.LoginresponseDTO;
import com.fmt.Umd.Dto.RegistrationDto;
import com.fmt.Umd.model.Module;
import com.fmt.Umd.model.User;
import com.fmt.Umd.service.AuthenticationService;
import com.fmt.Umd.service.MailService;
import com.fmt.Umd.service.ModuleService;
import com.fmt.Umd.service.OtpHoldingService;
import com.fmt.Umd.service.RegistrationService;
import com.fmt.Umd.service.RoleService;
import com.fmt.Umd.service.TokenService;
import com.fmt.Umd.service.UserDetailsServices;
@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/auth/")
public class AuthenticationController {
	@Autowired
	public AuthenticationManager authenticationManager;
	@Autowired
	public UserDetailsServices userDetailsServices;
	@Autowired
	public AuthenticationService  authenticationService;
	@Autowired
	public TokenService tokenService;
	@Autowired
	public MailService mailService;
	@Autowired
	public OtpHoldingService otpHoldingService;
	@Autowired
	private RegistrationService registrationService;
   @Autowired
   private ModuleService moduleService;
   @Autowired
   private RoleService roleService;
	@PostMapping("login")
	public LoginresponseDTO getUserAuthentication(@RequestBody User user) {
		LoginresponseDTO loginresponseDTO=null;
		try {
			System.out.println("Login method executed :"+user.getUsername()+"User name and password :"+user.getPassword());
		  Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	   String token= tokenService.getGenratedToken(authentication);
	   System.out.println("TOKEN  :"+token);
	  // Set<String>  endpoints= roleService.getRolesByUserName(user.getUsername());
	   Set<Module> moduleset=roleService.getRolesByUserName(user.getUsername());
	 // Set<Module> moduleset= moduleService.getModuleListBySetOfEndpoints(endpoints);
		User user2=authenticationService.getUserByUserName(user.getUsername());
		 loginresponseDTO=new LoginresponseDTO(user,token,moduleset);
		if(token!=null) {
          List<GrantedAuthority> authorities=(List<GrantedAuthority>)authentication.getAuthorities();
 
		}
		  
		}
		catch(Exception ex) {
		ex.printStackTrace();	
		}
		return loginresponseDTO;
	}
	@PostMapping("register")
	public String registration(@RequestBody RegistrationDto rdto) {
		
		try {
			String email=rdto.getEmail();
			String username=rdto.getUsername();
			String password=rdto.getPassword();
			
			
           Integer otp=mailService.sendVerificationEmail(email);
           registrationService.register(username, password, email,otp);
				
			
         }catch(Exception ex) {
			ex.printStackTrace();
		}
		return "Mail send successfully";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
