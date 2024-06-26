package in.Ashokit.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Ashokit.entity.Products;

public interface Productrepo  extends JpaRepository<Products, Integer>{

	
	public  Optional<Products> findByName(String name);
	
	public List<Products> findByPrize(Double prize);
	
	public List<Products> findByNameAndPrize(String name,Double prize);
}
