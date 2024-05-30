package in.Ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Ashokit.entity.Enrollment;

public interface Enrollmentrpo extends JpaRepository<Enrollment, Long>{

	
	public List<Enrollment> findByStudentidAndCouseid(Long studentid,Long couseid);
	
	public  List<Enrollment> findByStudentid(Long studentid);
}
