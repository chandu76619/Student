package in.Ashokit.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import feign.FeignException;
import in.Ashokit.Binding.Courses;
import in.Ashokit.Binding.Student;
import in.Ashokit.entity.Enrollment;
import in.Ashokit.feign.Coursefeign;
import in.Ashokit.feign.Studentclient;
import in.Ashokit.repo.Enrollmentrpo;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
	
	@Autowired
	private Enrollmentrpo erepo;
	@Autowired
	private Coursefeign cclient;
	@Autowired
	private Studentclient sclient;
	
	



	public void enrollment(Enrollment enrollment) {
		
		erepo.save(enrollment);
	}
	
	 
	 
	 public ResponseEntity<Optional<Courses>> getCourseById(Long couseid) {
		    return cclient.getbyid(couseid);
		}
	 public ResponseEntity<Optional<Student>> getstudentid(Long studentid) {
		    return sclient.getstudent(studentid);
		}
	 
	 
	 public Optional<Enrollment> getbyid(Long id){
		 
		 
		return erepo.findById(id);
	 }
	 public List<Courses> getCoursesForStudent(Long studentid) {
	        List<Enrollment> enrollments = erepo.findByStudentid(studentid);
/*
	        return enrollments.stream()
	                .map(enrollment -> cclient.getbyid(enrollment.getCouseid()).getBody().orElse(null))
	                .filter(Objects::nonNull)
	                .collect(Collectors.toList());
	        */
	       
	        List<Courses> courses =new ArrayList<>();
	        for(Enrollment enrollment:enrollments) {
	        	 Optional<Courses> optional = cclient.getbyid(enrollment.getCouseid()).getBody();
	        	if(optional.isPresent()) {
	        		courses.add(optional.get());
	        		
	        	}
	        }
	        return courses;
	       
	 }
	  
	 public List<Student> getStudentsForCourse(Long couseid) {
		    List<Enrollment> enrollments = erepo.findByCouseid(couseid);

		    List<Student> students =new ArrayList<>();
		    for (Enrollment enr : enrollments) {
		      Optional<Student> optional = sclient.getstudent(enr.getStudentid()).getBody();
		        if (optional.isPresent()) {
		            students.add(optional.get());
		        }
		    }
		    return students;
		}
	 /*
	 public List<Student> getStudentsForCourse(Long couseid) {
		    List<Enrollment> enrollments = erepo.findByCouseid(couseid);

		    List<Student> students = new ArrayList<>();
		    for (Enrollment enrollment : enrollments) {
		        try {
		            ResponseEntity<Optional<Student>> responseEntity = sclient.getstudent(enrollment.getStudentid());
		            if (responseEntity.getStatusCode().is2xxSuccessful()) {
		                Optional<Student> optional = responseEntity.getBody();
		                if (optional.isPresent()) {
		                    students.add(optional.get());
		                }
		            } else {
		                // Log the error message
		                System.err.println("Error getting student for ID " + enrollment.getStudentid() + ". Status: " + responseEntity.getStatusCode());
		            }
		        } catch (FeignException e) {
		            // Log the FeignException
		            System.err.println("Error getting student for ID " + enrollment.getStudentid() + ": " + e.getMessage());
		        }
		    }
		    return students;
		}
 */

	}
	


	


