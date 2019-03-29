package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

	public static void main(String[] args) {
		 SpringApplication.run(App.class, args);
	}
	@GetMapping
	public String method1(){
		System.out.println("Method1 invoked ... ");
		return "<h1 style='color:blue'>Show Page</h1>";
	}

}
