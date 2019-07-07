package com.tap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student")
public class Student {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@ManyToOne(fetch= FetchType.LAZY,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE,
						 CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="verticalid",referencedColumnName="id")
	private Vertical vertical;
	
	@ManyToOne(fetch= FetchType.LAZY,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			 			 CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="schoolid",referencedColumnName="id")
	private School school;
	
		
	// define constructors
	
	public Student() {
		
	}


	public Student(int id, String firstName, String lastName, Vertical vertical, School school) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vertical = vertical;
		this.school = school;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getVertical() {
		return vertical.getName();
	}


	public void setVertical(Vertical vertical) {
		this.vertical = vertical;
	}


	public String getSchool() {
		return school.getName();
	}


	public void setSchool(School school) {
		this.school = school;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", vertical=" + vertical
				+ ", school=" + school + "]";
	}


}











