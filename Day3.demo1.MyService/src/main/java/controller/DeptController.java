package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Dept;
import repo.DeptRepository;

@RestController
@RequestMapping(value="/search")
public class DeptController {
	@Autowired
	private DeptRepository repo;
	@GetMapping(value="/{loc}")
	public List<Dept> find(@PathVariable(name="loc") String loc){
		System.out.println("in DeptController  find method invoked" );
		return repo.findByLoc(loc);
	}
}
