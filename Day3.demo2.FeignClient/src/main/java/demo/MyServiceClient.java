package demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient( name ="fgcl", url="http://localhost:8080")
public interface MyServiceClient {
	
	@RequestMapping(method=RequestMethod.GET, value="/{loc}")
	public List<Dept> find(@PathVariable(name="loc") String loc);
}
