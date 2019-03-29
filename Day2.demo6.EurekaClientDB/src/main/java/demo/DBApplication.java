package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages="demo")
public class DBApplication {
	@Autowired
	private DeptRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(DBApplication.class, args);
	}
	@Bean
	public String method1(){
		for (int i = 2000; i <3000;i+=10)
		{
				Dept d= new Dept();
				d.setDeptno(i);
				d.setDname("Nm"+i);
				if ((i %20)==0)
					d.setLoc("Hyd" );
				else
					d.setLoc("Blr");
				repo.save(d);
		}
		return "Success";
	}
}
