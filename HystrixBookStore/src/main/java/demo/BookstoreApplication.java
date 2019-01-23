package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class BookstoreApplication {

  @RequestMapping(value = "/recommended")
  public String readingList(){
    return "BSA: Spring in Action (Manning), <br> BSA: Cloud Native Java (O'Reilly), <br> BSA: Learning Spring Boot (Packt)";
  }
  
  @RequestMapping(value = "/m1")
  public String readingM1(){
    return "M1 from Book store";
  }
  
  @RequestMapping(value = "/m2")
  public String readingM2(){
    return "M2 from book store";
  }

  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
  }
}