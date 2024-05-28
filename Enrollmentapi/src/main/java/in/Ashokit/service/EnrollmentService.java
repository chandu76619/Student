package in.Ashokit.service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.Ashokit.Binding.Courses;
import in.Ashokit.Binding.Student;
import in.Ashokit.entity.Enrollment;
import in.Ashokit.feign.Coursefeign;
import in.Ashokit.feign.Studentclient;
import in.Ashokit.repo.Enrollmentrpo;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
	
	
	private Enrollmentrpo erepo;
	private Coursefeign cclient;
	private Studentclient sclient;
	
	@Autowired
	public EnrollmentService(Enrollmentrpo erepo, Coursefeign cclient, Studentclient sclient) {
		super();
		this.erepo = erepo;
		this.cclient = cclient;
		this.sclient = sclient;
	}


	public void enrollment(Enrollment enrollment) {
		
		erepo.save(enrollment);
	}
	
	
	
}
