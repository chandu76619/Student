package in.Ashokit.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.Ashokit.entity.Products;
import in.Ashokit.service.ProductService;
@RestController
public class Productcontroller {

	@Autowired
	private ProductService pservice;
	@PostMapping("/save")
	public ResponseEntity<String> saveproduts(@RequestBody Products products){
	
		boolean saveproducts = pservice.saveproducts(products);
		
		if(saveproducts) {
	
	return new ResponseEntity<>("saved sucessfully", HttpStatus.OK);
	}
		else {
			return new ResponseEntity<>(" Failed to saved", HttpStatus.BAD_REQUEST);
		}			
		}
	@GetMapping("/getall")
	public ResponseEntity<List<Products>> getproducts(){
		
		
		return new ResponseEntity<>(pservice.getallproducts(),HttpStatus.OK );
		
	}
	@GetMapping("/product/{name}")
	public ResponseEntity<Optional<Products>> getbyid(@PathVariable String name){
	
	Optional<Products> getproductbyname = pservice.getproductbyname(name);
	
	return new ResponseEntity<>(getproductbyname,HttpStatus.OK);
	}
	@GetMapping("/products")
	public ResponseEntity<List<Products>> getproductbyprize(@RequestParam Double prize){
		
		List<Products> getproductbyname = pservice.getproductbyname(prize);
		
		return new  ResponseEntity<>(getproductbyname,HttpStatus.OK);
	}
	
	@GetMapping("/productes/{prize}")
	public ResponseEntity<List<Products>> getbynameandprize(@RequestParam  String name,@PathVariable  Double prize){
		
	return new ResponseEntity<>(pservice.getproductbynameandprize(name, prize),HttpStatus.OK);
	}
	
}
