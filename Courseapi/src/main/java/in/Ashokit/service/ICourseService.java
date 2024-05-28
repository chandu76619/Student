package in.Ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Ashokit.entity.Courses;
import in.Ashokit.repo.Courserepo;
@Service
public class ICourseService implements CourseService{
@Autowired
	private Courserepo repo;
	@Override
	public boolean savecourse(Courses c) {
		
Courses courses = repo.save(c);
		return courses!=null;
	}

	@Override
	public List<Courses> getcourses() {
		
		
		return repo.findAll();
	}

	@Override
	public Optional<Courses> getbyid(Long id) {
		Optional<Courses> byId = repo.findById(id);
		
		return byId;
	}

	@Override
	public void deletebyid(Long id) {
	
		boolean existsById = repo.existsById(id);
		if(existsById) {
			repo.deleteById(id);
		}
	}

	@Override
	public Courses update(Long id, Courses c) {
		
		Optional<Courses> byId = repo.findById(id);
		if(byId.isPresent()) {
			
			BeanUtils.copyProperties(c, byId,"id");
			
			return repo.save(c);
		}else {
			
			throw new RuntimeException("Employee not found with id " + id);
		}
		
		
	}

	@Override
	public boolean existById(Long id) {
		
		boolean existsById = repo.existsById(id);
		return existsById;
	}

	
}
