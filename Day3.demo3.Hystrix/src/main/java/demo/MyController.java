package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value="/")
public class MyController {
	@Autowired
	private MyServiceClient myservice;
	
	final String str = "<br/><h1><a href='/index.html'>Home </a></h1>";
	@GetMapping(value="/m1")
	public String method1(){
		return "<h1>Method1 executed </h1>" + str;
	}
	@PostMapping(value="/m2")
	public String method2(){
		return "<h1>Method2 executed </h1>" + str;
	}
	@GetMapping(value="/m3")
	@HystrixCommand(commandKey="speed",groupKey="perf")
	public String method3(){
		try {
			Thread.sleep((long)(Math.random()*100000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "<h1>Method1 executed </h1>" + str;
	}
	@GetMapping(value="/m4/{param}")
	@HystrixCommand(commandKey="arith",groupKey="divide")
	public String method4(@PathVariable(name="param") int no){
		int i = 100/no;
		return "<h1>Method4 executed, division = "  + i + "</h1>" + str;
	}
	@GetMapping(value="/m5/{param}")
	
	@HystrixCommand(commandKey="default",groupKey="calltodb", fallbackMethod="myfallbackform5")
	public String method5(@PathVariable(name="param") String loc){
		System.out.println("Original Method");
		List<Dept> list = myservice.find(loc);
		String str1 = "<table border='1' bgcolor='cyan' >";
		for (Dept e : list) {
			 str1+="<tr><td>"+e.getDeptno()+"</td><td>" + e.getDname() +"</td><td>"+e.getLoc() +"</td></tr>";	
		}
		str1+= "</table>";
		return str1  + str;
	}
	
	public  String myfallbackform5(@PathVariable(name="param") String loc){
		System.out.println("fallback Method");
		String str1 = "<table border='1' bgcolor='cyan' ><tr><td>Default Data</td></tr></table>";
		return str1+ str;
	}
}
