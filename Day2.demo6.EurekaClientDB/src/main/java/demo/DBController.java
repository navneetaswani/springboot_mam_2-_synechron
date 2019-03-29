package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/dept")
public class DBController {
	@Autowired
	private DeptRepository repo;
	
	@GetMapping
	public List<Dept> get(){
		return repo.findAll();
	}
}
