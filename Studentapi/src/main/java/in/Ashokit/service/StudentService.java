package in.Ashokit.service;

import java.util.List;
import java.util.Optional;

import in.Ashokit.entity.Student;

public interface StudentService {

	
	public boolean savestudents(Student s);
	
	public List<Student> getall();
	
	public Optional<Student> getById(Long sid);;
	
	public Student update(Long sid,Student s);
	
	public void deletebyid(Long sid);
	
	public boolean existbyid(Long id);
}
