package com.tap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="school")
public class School {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;	
	
	@Column(name="city")
	private String city;
	
	@OneToMany(fetch= FetchType.LAZY,
			mappedBy="school",  targetEntity = Volunteer.class,
				cascade = {CascadeType.PERSIST,CascadeType.MERGE,
					CascadeType.DETACH,CascadeType.REFRESH})
	private List<Volunteer> volunteers;
	
	@OneToMany(fetch= FetchType.LAZY,
			mappedBy="school", targetEntity = Student.class,
				cascade = {CascadeType.PERSIST,CascadeType.MERGE,
						CascadeType.DETACH,CascadeType.REFRESH})
	private List<Student> students;
		
	// define constructors
	
	public School() {
		
	}

	public School(int id, String name, String address, String city, List<Volunteer> volunteers,
			List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.volunteers = volunteers;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Volunteer> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(List<Volunteer> volunteers) {
		this.volunteers = volunteers;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}











