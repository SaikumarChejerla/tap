package com.tap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="verticalid")
	private int vertical;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobilenumber")
	private long mobileNumber;
	
	@Column(name="schoolid")
	private int schoolId;
		
	// define constructors
	
	public Volunteer() {
		
	}

	public Volunteer(int id, String firstName, String lastName, int vertical, String email, long mobileNumber,int schoolId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vertical = vertical;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.schoolId = schoolId;
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

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
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

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", vertical=" + vertical
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", schoolId=" + schoolId + "]";
	}
	
}











