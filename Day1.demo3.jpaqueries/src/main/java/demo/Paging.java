package demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Emp;
import repo.EmpRepository;

@RestController
@RequestMapping(value="/page")
public class Paging {
	@Autowired
	private EmpRepository repo;
	
	public Paging(){
		System.out.println(" in paging constructor ");
	
	}
	@GetMapping(value = "/{pageno}")
	public List<Emp> list(@PathVariable(name="pageno") int pageno){
		System.out.println(" in list .." + pageno);
		if (pageno == 1)
			return repo.findAll (PageRequest.of(1, 5).first()).get().collect(Collectors.toList());
		else
			return repo.findAll (PageRequest.of(pageno-2, 5).next()).get().collect(Collectors.toList());
	}
}

