package in.rahulit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController {
	
	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDB", name = "ashokIT")
	public String getData() {
		
		System.out.println("Redis method called....");
		
		int i = 10/0;
		
		return "Redis data sent to your email....";
		
	}
	
	public String getDataFromDB(Throwable t) {
		System.out.println("DB Method called");
		
		return "DB data sent to your email";
	}
	
}
