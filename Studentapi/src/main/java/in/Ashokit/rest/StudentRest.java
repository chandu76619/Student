package in.Ashokit.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.Ashokit.entity.Student;
import in.Ashokit.service.StudentService;

@RestController
public class StudentRest {
@Autowired
	private StudentService sservice;
	
@PostMapping("/saved")
	public ResponseEntity<String>  savestudents(@RequestBody  Student s){
		
		boolean savestudents = sservice.savestudents(s);
		if(savestudents)
		
		return new ResponseEntity<>("Data saved Sucessfully",HttpStatus.CREATED);
		else
			
			return new ResponseEntity<>("Data failed to save",HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/getstudent/{sid}")
	public ResponseEntity<Optional<Student>> getstudent(@PathVariable Long sid){
		
		Optional<Student> optional = sservice.getById(sid);
		
		return new ResponseEntity<>(optional,HttpStatus.OK);
	}
	
	@GetMapping("/getallstudents")
	public ResponseEntity<List<Student>> getallstudents(){
		List<Student> getall = sservice.getall();
		
		return new ResponseEntity<>(getall,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable Long id){
		sservice.deletebyid(id);
		return new ResponseEntity<>("student deleted sucessfully",HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable  Long id, @RequestBody  Student s){
		
		Student student = sservice.update(id, s);
		
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}
	
	@GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existbyid(@PathVariable Long id) {
        boolean existsById = sservice.existbyid(id);

        if (existsById) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
	
	
}
