package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/dept")
public class DeptController {
	
	private List<Dept> list = new ArrayList<Dept>();
	
	@GetMapping()
	public List<Dept> list() {
		System.out.println("in list " + list.size());
		return list;
	}
	
	@GetMapping("/{dno}")
	public ResponseEntity<Dept> getonerec(@PathVariable(name="dno")int deptno) {
		System.out.println("in getonerecords " + deptno);
		for (Dept dept : list) {
			if (dept.getDeptno() == deptno)
			{
				System.out.println("GetOneRecord - Found" + deptno);
				return ResponseEntity.status(HttpStatus.OK).body(dept);
			}
		}
		System.out.println("GetOneRecord - Not found" + deptno);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
		
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody Dept d) {
		System.out.println("in create " + d);
		list.add(d);
		return "Success";
	}
	
	@DeleteMapping("/{dno}")
	public ResponseEntity<String> delete(@PathVariable(name="dno")int deptno) {
		System.out.println("in delete " + deptno);
		
		for(Dept dept : list)
		{
		    if (dept.getDeptno() == deptno)
		    {
		    	System.out.println("delete - found" + deptno);
		        list.remove(dept);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		    }
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dept> update(@RequestBody Dept d) {
		System.out.println("in update " + d);
		for (Dept dept : list) {
			if (dept.getDeptno() == d.getDeptno())
			{
				System.out.println("update - Found" + d.getDeptno());
				dept.setDname(d.getDname());
				dept.setLoc(d.getLoc());
				return ResponseEntity.ok().body(dept);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}