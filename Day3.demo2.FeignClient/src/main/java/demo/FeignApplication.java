package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@SpringBootApplication
@EnableFeignClients
public class FeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}
	@Bean
	public RequestInterceptor myinterceptor(){
		return new RequestInterceptor() {
			
			@Override
			public void apply(RequestTemplate template) {
				template.header("user-agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
				
			}
		};
	}
	
	
}
