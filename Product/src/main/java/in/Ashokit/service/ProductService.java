package in.Ashokit.service;

import java.util.List;
import java.util.Optional;

import in.Ashokit.entity.Products;

public interface ProductService {

	
	public boolean saveproducts(Products product);
	
	public List<Products> getallproducts();
	
	
	public Optional<Products> getproductbyname(String name);
	
	public void deletebyid(Integer pid);
	
	public List<Products> getproductbyname(Double prize);
	
	public List<Products> getproductbynameandprize(String name,Double prize);
	
}
