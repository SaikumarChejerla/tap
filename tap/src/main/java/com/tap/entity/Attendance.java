package com.tap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="attendance")
public class Attendance implements Serializable  {

	private static final long serialVersionUID = 1L;

	@JsonManagedReference
	@ManyToOne(fetch= FetchType.LAZY,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE,
						 CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="studentid",referencedColumnName="id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Student studentid;
	
	@Id
	@Column(name="date")
	private String date;
	
	@Column(name="present")
	private boolean present;
	
	@Column(name="absent")
	private boolean absent;
	
	@Column(name="outofclass")
	private boolean outofclass;

	// define constructors
	
	public Attendance() {
		
	}

	public Attendance(Student studentid, String date, boolean present, boolean absent, boolean outofclass) {
		this.studentid = studentid;
		this.date = date;
		this.present = present;
		this.absent = absent;
		this.outofclass = outofclass;
	}

	public Student getStudentid() {
		return studentid;
	}

	public void setStudentid(Student studentid) {
		this.studentid = studentid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public boolean isAbsent() {
		return absent;
	}

	public void setAbsent(boolean absent) {
		this.absent = absent;
	}

	public boolean isOutofclass() {
		return outofclass;
	}

	public void setOutofclass(boolean outofclass) {
		this.outofclass = outofclass;
	}


}











