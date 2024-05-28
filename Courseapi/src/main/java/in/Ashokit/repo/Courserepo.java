package in.Ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Ashokit.entity.Courses;

public interface Courserepo extends JpaRepository<Courses, Long>{
	public boolean existsById(Long id);
}
