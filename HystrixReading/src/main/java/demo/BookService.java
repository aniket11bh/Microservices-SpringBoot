package demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookService {

	private final RestTemplate restTemplate;

	public BookService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		System.out.println("In Reading List ...");
		URI uri = URI.create("http://localhost:8090/recommended");

		return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		System.out.println("In Reliable ...");
		return "RA : Cloud Native Java (O'Reilly)";
	}

}