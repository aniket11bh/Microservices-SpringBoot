package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController(value="/")
public class DisplayController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public String display() {
		
//		String url = "http://localhost:8080/dept";
		String url = "http://DB/dept";
		String str = restTemplate.getForObject(url, String.class);
		
		return "<h1>In display + " + str + "</h1>";
	}
}
