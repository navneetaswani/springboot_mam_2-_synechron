package demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import serv.MyService;

@SpringBootApplication(scanBasePackages="controllers,serv,secconf")
public class SecureApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx = SpringApplication.run(SecureApplication.class, args);
	
	SecurityContext secctx = new SecurityContextImpl();
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
	List<GrantedAuthority> grantedAuths =
            AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_adm");
	
	Authentication auth = new UsernamePasswordAuthenticationToken("user1","pass1",grantedAuths);
	System.out.println(auth.getCredentials());
	secctx.setAuthentication(auth);
	
	SecurityContextHolder.setContext(secctx);
	
	MyService mys = ctx.getBean("myservice", MyService.class);
	
	try {
		mys.m1();
	} catch (Exception e) {
		System.out.println("Problem invoking m1\n\n"   + e);
		e.printStackTrace();
	}	
	try {
		mys.m2();
	} catch (Exception e) {
		System.out.println("Problem invoking m2\n\n"   + e);
		
	}
		
		
	}

}
