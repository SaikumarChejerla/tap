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

@Entity
@Table(name="volunteer")
public class Volunteer {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobilenumber")
	private long mobileNumber;
	
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
	
	public Volunteer() {
		
	}

	public Volunteer(int id, String firstName, String lastName, String email, long mobileNumber, Vertical vertical,
			School school) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
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

}











