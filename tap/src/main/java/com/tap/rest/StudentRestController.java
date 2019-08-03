package com.tap.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/student/{studentid}")
	public Student findById(@PathVariable int studentid) {
		return studentDAO.findById(studentid);
	}
	
	@PostMapping(value="/student")
	public Student saveStudent(@RequestBody Student student) {
		
		student.setId(0);
		studentDAO.saveStudent(student);
		
		return student;
	}
	
}










