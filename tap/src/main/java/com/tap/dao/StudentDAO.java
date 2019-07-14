package com.tap.dao;

import java.util.List;

import com.tap.entity.Student;
import com.tap.entity.Volunteer;

public interface StudentDAO {

	public List<Student> findAll();

	public List<Student> getByVolunteer(Volunteer volunteer);
		
}
