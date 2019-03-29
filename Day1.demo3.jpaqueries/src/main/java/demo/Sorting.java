package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Emp;
import repo.EmpRepository;

@RestController
@RequestMapping(value="/sort")
public class Sorting {
	@Autowired
	private EmpRepository repo;
	@GetMapping(value="/{fn}")
	public List<Emp> sort1(@PathVariable(name="fn")String fname){
		Sort sort = new Sort(Sort.Direction.ASC, fname);
		return repo.findAll(sort);
	}
	@GetMapping(value="/{fn}/{dir}")
	public List<Emp> sort1(@PathVariable(name="fn")String fname,
			@PathVariable(name="dir")String dir	){
		Sort sort = null;
		if (dir.equals("asc"))
			sort = new Sort(Sort.Direction.ASC, fname);
		else
			 sort = new Sort(Sort.Direction.DESC, fname);
		return repo.findAll(sort);
	}
}
