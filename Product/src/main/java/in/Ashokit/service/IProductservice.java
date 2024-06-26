package in.Ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.Ashokit.entity.Products;
import in.Ashokit.repo.Productrepo;
@Service
public class IProductservice implements ProductService {
	
	private Productrepo prepo;
	

	public IProductservice(Productrepo prepo) {
		super();
		this.prepo = prepo;
	}

	@Override
	public boolean saveproducts(Products product) {
		Products products = prepo.save(product);
		return products !=null;
	}

	@Override
	public List<Products> getallproducts() {
		
		List<Products> list = prepo.findAll();
		return list;
	}

	@Override
	public Optional<Products> getproductbyname(String name){	
		
		Optional<Products> byName = prepo.findByName(name);
		return byName;
	}

	@Override
	public void deletebyid(Integer pid) {
		 prepo.deleteById(pid);
	}

	@Override
	public List<Products> getproductbyname(Double prize) {
		
		List<Products> byPrize = prepo.findByPrize(prize);

		return byPrize;
	}

	@Override
	public List<Products> getproductbynameandprize(String name, Double prize) {
		List<Products> byNameAndPrize = prepo.findByNameAndPrize(name, prize);
		return byNameAndPrize;
	}
	

}
