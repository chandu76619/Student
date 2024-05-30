package in.Ashokit.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.Ashokit.Binding.Courses;



@FeignClient(name="COURSEAPI")
public interface Coursefeign {

	@PostMapping("/save")
	ResponseEntity<String> savecourses(@RequestBody  Courses c);
	
	@GetMapping("/getby/{id}")
	public ResponseEntity<Optional<Courses>> getbyid(@PathVariable Long id);
	
	@GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existbyid(@PathVariable Long id);
}
