package in.Ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.Ashokit.Binding.Product;
import in.Ashokit.feignclient.Productapiclient;



@RestController
public class ecommerce {

	
	@Autowired
	private Productapiclient client;
	
	
	@PostMapping("/savepro")
	public ResponseEntity<String> saveproduct(@RequestBody  Product product){
		return client.saveproduts(product);
		
				}
	@GetMapping("/getallproducts")
	public ResponseEntity<List<Product>> getall(){
		
		
		return client.getproducts();
	}
				
	}

