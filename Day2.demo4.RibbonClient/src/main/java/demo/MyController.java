package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping
	public String show(){
		System.out.println("in ribbonclientapplication");
		//String url = "http://localhost:8090/";
		String url = "http://sayhello";
		String data =template.getForEntity(url, String.class).getBody();
		return "Server Returned " + data;
	}
	
}
