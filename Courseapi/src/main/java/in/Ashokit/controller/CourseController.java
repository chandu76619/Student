package in.Ashokit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.Ashokit.entity.Courses;
import in.Ashokit.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;
	
	@PostMapping("/save")
	ResponseEntity<String> savecourses(@RequestBody  Courses c){
		
		boolean savecourse = service.savecourse(c);
		if(savecourse) {
			return new ResponseEntity<>("saved ",HttpStatus.CREATED);
		}else {
			
			return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/getby/{id}")
	public ResponseEntity<Optional<Courses>> getbyid(@PathVariable Long id){
		
		Optional<Courses> getbyid = service.getbyid(id);
		
		
		return new ResponseEntity<>(getbyid,HttpStatus.OK);
	}
	
	
	 @GetMapping("/exists/{id}")
	    public ResponseEntity<Boolean> existbyid(@PathVariable Long id) {
	        boolean existsById = service.existById(id);

	        if (existsById) {
	            return new ResponseEntity<>(true, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	        }
	    }
}
