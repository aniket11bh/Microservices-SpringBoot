package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController(value = "/")
public class MyApp {

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}

	@GetMapping()
	public String data() {
		return "<h1 style='color:green;'> In MyApp </h1>";
	}

	@RequestMapping(value = "/m1")
	public String readingM1() {
		return "M1 from My app";
	}

	@RequestMapping(value = "/m2")
	public String readingM2() {
		return "M2 from My app";
	}
}
