package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import entities.Dept;
import repo.DeptRepository;

@SpringBootApplication(scanBasePackages="controller")
@EnableJpaRepositories(basePackages="repo")
@EntityScan(basePackages="entities")
public class MyServiceApplication {
	@Autowired
	private DeptRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(MyServiceApplication.class, args);
	}
	@Bean
	public String method1(){
		for (int i = 10; i <100;i+=10)
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
