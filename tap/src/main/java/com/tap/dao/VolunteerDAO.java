package com.tap.dao;

import java.util.List;

import com.tap.entity.Volunteer;

public interface VolunteerDAO {

	public List<Volunteer> findAll();
	
	public Volunteer getById(int id);
		
}
