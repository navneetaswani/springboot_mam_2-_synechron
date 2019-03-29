package demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="a", url="https://reqres.in/")
public interface ReqResClient {
	@GetMapping(path="api/users/2")
	public UserData get();
}
