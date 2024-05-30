package in.Ashokit.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;
	private Long studentid;
	private Long couseid;
	
	
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}
	public Long getCouseid() {
		return couseid;
	}
	public void setCouseid(Long couseid) {
		this.couseid = couseid;
	}
	
	
}
