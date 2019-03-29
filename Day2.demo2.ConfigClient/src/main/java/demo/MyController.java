package demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyController {
	@Value(value="${message:HelloDefaultNotfromGit}")
	private String message;
	
	@GetMapping(value="/")
	public String message(){
		return "<h1>Current message =  "+ message + " at  " + new Date() +" </h1>";
	}
}
