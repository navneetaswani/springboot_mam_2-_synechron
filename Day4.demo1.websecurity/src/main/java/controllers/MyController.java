package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/admin")
public class MyController {
	@GetMapping(value="/m1")
	public String method1(){
		System.out.println("in method1..");
		return "<h1>Method1 Invoked </h1>";
	}
	@GetMapping(value="/m2")
	public String method2(){
		System.out.println("in method2..");
		return "<h1>Method2 Invoked </h1>";
	}
}
