package demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class MyController {

	@GetMapping(value="/insert")
	public String insert() {
		return "<h2>Insert <a href='/'> Home </a></h2>";
	}
	
	@GetMapping(value="/list")
	public String list() {
		return "<h2>List <a href='/'> Home </a></h2>"; 
	}
}
