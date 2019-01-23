package demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/dept")
public class DeptController {
	
	@Autowired
	private DeptRepository repo;
	private List<Dept> list = new ArrayList<Dept>();
	
	@PostConstruct()
	public void inserttest() {
		for (int i=10; i<60; i+=10) {
			Dept d = new Dept();
			d.setDeptno(i);
			d.setDname("Dname of " + i);
			if (i%20 == 0) {
				d.setLoc("pnq");
			}
			else {
				d.setLoc("hyd");
			}
			repo.save(d);
		}
	}
	
	@GetMapping()
	public List<Dept> list() {
		System.out.println("In list " + list.size());
		return repo.findAll();
	}	
}