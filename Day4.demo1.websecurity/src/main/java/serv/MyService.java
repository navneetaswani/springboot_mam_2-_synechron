package serv;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service(value="myservice")
public class MyService {
	@Secured(value="ROLE_adm")
	public void m1(){
		System.out.println("in method1..");
		
	}
	
	@Secured(value="ROLE_usr")
	public void m2(){
		System.out.println("in method2..");
		
	}
}
