package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="demo,demo.config")
public class SpringSecurityClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityClientApplication.class, args);
	}
}
