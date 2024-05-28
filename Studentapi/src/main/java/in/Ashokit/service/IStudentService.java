package in.Ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Ashokit.entity.Student;
import in.Ashokit.repo.Studentrepo;
@Service
public class IStudentService implements StudentService{

	@Autowired
	private Studentrepo srepo;

	@Override
	public boolean savestudents(Student s) {
		
		Student student = srepo.save(s);
		return student!=null;
	}

	@Override
	public List<Student> getall() {
		
		List<Student> list = srepo.findAll();

		return list;
	}

	@Override
	public Optional<Student> getById(Long sid) {
	Optional<Student> student = srepo.findById(sid);
	
	return student;
	}

	@Override
	public Student update(Long sid, Student s) {
		
		Optional<Student> byId = srepo.findById(sid);
		if(byId.isPresent()) {
			Student student = byId.get();
			/*student.setName(s.getName());
			student.setEmail(s.getEmail());
			student.setPhno(s.getPhno());
			*/
			BeanUtils.copyProperties(s, student,"sid");
			return srepo.save(student) ;
		}else {
			 throw new RuntimeException("Employee not found with id " + sid);
		}
		
		
	}

	@Override
	public void deletebyid(Long sid) {
		
		if(srepo.existsById(sid)) {
			
			srepo.deleteById(sid);
		}
		else {
			  throw new RuntimeException("Student not found with id " + sid);
		}
	}

	@Override
	public boolean existbyid(Long id) {
		boolean existsById = srepo.existsById(id);

		return existsById;
	}
	
}
