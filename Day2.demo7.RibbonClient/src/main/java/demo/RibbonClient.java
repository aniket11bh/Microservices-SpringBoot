package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController(value = "/")
@org.springframework.cloud.netflix.ribbon.RibbonClient(name = "say-hello", configuration = SayHelloConfiguration.class)
public class RibbonClient {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping()
	public String data() {
		String url = "http://say-hello/app";
		String str = restTemplate.getForObject(url, String.class);

		return "Server returned : " + str;
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonClient.class, args);
	}

}
