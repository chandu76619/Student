package in.Ashokit.service;

import java.util.List;
import java.util.Optional;

import in.Ashokit.entity.Courses;

public interface CourseService {

	public boolean savecourse(Courses c);
	public List<Courses> getcourses();
	
	public Optional<Courses> getbyid(Long id);
	
	public void deletebyid(Long id);
	
	public Courses update(Long id,Courses c);
	
	public boolean existById(Long id);
}
