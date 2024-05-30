package in.Ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.Ashokit.entity.Enrollment;

public interface Enrollmentrpo extends JpaRepository<Enrollment, Long>{

	
	List<Enrollment> findByStudentid(Long studentid);
	
	
	 List<Enrollment> findByCouseid(Long couseid);
}
