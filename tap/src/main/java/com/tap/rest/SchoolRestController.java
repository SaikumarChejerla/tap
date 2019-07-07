package com.tap.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.dao.SchoolDAO;
import com.tap.entity.School;;

@RestController
@RequestMapping("/api")
public class SchoolRestController {

	private SchoolDAO schoolDAO;
	
	@Autowired
	public SchoolRestController(SchoolDAO theSchoolDAO) {
		schoolDAO = theSchoolDAO;
	}
	
	// expose "/schools" and return list of employees
	@GetMapping("/schools")
	public List<School> findAll() {
		return schoolDAO.findAll();
	}

	
}










