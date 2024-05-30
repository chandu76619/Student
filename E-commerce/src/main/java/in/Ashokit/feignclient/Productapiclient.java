package in.Ashokit.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.Ashokit.Binding.Product;



@FeignClient(name="PRODUCT")
public interface Productapiclient {

	@PostMapping("/save")
	public ResponseEntity<String> saveproduts(@RequestBody Product product);
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getproducts();
}
