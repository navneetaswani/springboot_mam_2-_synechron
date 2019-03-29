package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Emp;
import repo.EmpRepository;

@RestController
@RequestMapping(value="/emp")
public class MyQueries {
	@Autowired
	private EmpRepository repo;
	@GetMapping(value="/{project}")
	public List<Emp> search1(@PathVariable(name="project") String project )
	{
		return repo.findByProject(project);
	}
	@GetMapping(value="q/{project}")
	public List<Emp> search11(@PathVariable(name="project") String project )
	{
		return repo.findByProj(project);
	}
	
	@GetMapping(value="/{project}/{ename}")
	public List<Emp> search2(@PathVariable(name="project") String project,
			@PathVariable(name="ename") String ename )
	{
		return repo.findByProjectAndEname(project, ename);
	}
	
	@GetMapping(value="ordemo/{project}/{ename}")
	public List<Emp> search3(@PathVariable(name="project") String project,
			@PathVariable(name="ename") String ename )
	{
		return repo.findByProjectOrEname(project, ename);
	}
	@GetMapping(value="bet/{min}/{max}")
	public List<Emp> search4(@PathVariable(name="min") double min,
			@PathVariable(name="max") double max )
	{
		return repo.findBySalaryBetween(min, max);
	}
}
