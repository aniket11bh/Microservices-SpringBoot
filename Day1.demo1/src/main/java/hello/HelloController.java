package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value="/")
public class HelloController {

    @RequestMapping()
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @GetMapping(value="/add1")
    public String add(@RequestParam(name="nm1")String name1, @RequestParam(name="nm2")String name2) {
    	return "<h1> Hello world, name = " + (name1 + name2) + "</h1>"; 
    }
    
    @GetMapping(value="/add2")
    public String add(@RequestParam(name="n1")int n1, @RequestParam(name="n2")int n2) {
    	return "<h1> Hello world, number = " + (n1 + n2) + "</h1>";
    }

}