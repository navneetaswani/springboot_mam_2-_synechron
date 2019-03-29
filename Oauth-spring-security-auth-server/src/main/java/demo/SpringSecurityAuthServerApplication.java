package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="demo,demo.config")
public class SpringSecurityAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthServerApplication.class, args);
	}
}
