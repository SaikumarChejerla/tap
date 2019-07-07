package com.tap.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.dao.StudentDAO;
import com.tap.entity.Student;;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private StudentDAO studentDAO;
	
	@Autowired
	public StudentRestController(StudentDAO theStudentDAO) {
		studentDAO = theStudentDAO;
	}
	
	// expose "/students" and return list of employees
	@GetMapping("/students")
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	
}










