package in.Ashokit.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.Ashokit.Binding.Student;



@FeignClient(name="STUDENTAPI")
public interface Studentclient {

	@PostMapping("/saved")
	public ResponseEntity<String>  savestudents(@RequestBody  Student s);
	
	@GetMapping("/getstudent/{sid}")
	public ResponseEntity<Optional<Student>> getstudent(@PathVariable Long sid);
	
	@GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existbyid(@PathVariable Long id);
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable Long id);
}
