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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="vertical")
public class Vertical {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@JsonBackReference
	@OneToMany(fetch= FetchType.LAZY,
			mappedBy="vertical",
				cascade = {CascadeType.PERSIST,CascadeType.MERGE,
					CascadeType.DETACH,CascadeType.REFRESH})
	private List<Student> students;
	
	@JsonBackReference
	@OneToMany(fetch= FetchType.LAZY,
			mappedBy="vertical",
			cascade = {CascadeType.PERSIST,CascadeType.MERGE,
				CascadeType.DETACH,CascadeType.REFRESH})
	private List<Volunteer> volunteers;

	// define constructors
	
	public Vertical() {
		
	}

	public Vertical(int id, String name, List<Student> students, List<Volunteer> volunteers) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
		this.volunteers = volunteers;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Volunteer> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(List<Volunteer> volunteers) {
		this.volunteers = volunteers;
	}

}











