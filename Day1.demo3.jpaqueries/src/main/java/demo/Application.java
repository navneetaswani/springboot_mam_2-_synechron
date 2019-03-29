package demo;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import entities.Emp;
import repo.EmpRepository;

@SpringBootApplication()
@EntityScan(basePackages="entities")
@EnableJpaRepositories(basePackages="repo")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	private EmpRepository repo;
	@Bean
	public String method1(){
		List<String> names = Arrays.asList("simran", "salim", "lina", "lila", "varun","arun");
		List<String> projects = Arrays.asList("project1", "project2");
		for(int i = 1; i < 20;i++)
		{
			Emp e = new Emp();
			e.setEname(names.get(i % names.size()));
			e.setSalary(i* 100);
			e.setProject(projects.get(i % projects.size()));
			repo.save(e);
		}
		
		return "S";
	}
}
