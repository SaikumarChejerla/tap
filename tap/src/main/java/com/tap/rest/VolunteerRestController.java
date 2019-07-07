package com.tap.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.dao.VolunteerDAO;
import com.tap.entity.Volunteer;;

@RestController
@RequestMapping("/api")
public class VolunteerRestController {

	private VolunteerDAO volunteerDAO;
	
	@Autowired
	public VolunteerRestController(VolunteerDAO theVolunteerDAO) {
		volunteerDAO = theVolunteerDAO;
	}
	
	// expose "/students" and return list of employees
	@GetMapping("/volunteers")
	public List<Volunteer> findAll() {
		return volunteerDAO.findAll();
	}

	
}










