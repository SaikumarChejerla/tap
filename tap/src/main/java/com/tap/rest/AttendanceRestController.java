package com.tap.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.dao.AttendanceDAO;
import com.tap.entity.Attendance;

@RestController
@RequestMapping("/api")
public class AttendanceRestController {

	private AttendanceDAO attendanceDAO;
	
	@Autowired
	public AttendanceRestController(AttendanceDAO theAttendanceDAO) {
		attendanceDAO = theAttendanceDAO;
	}
	
	// expose "/schools" and return list of employees
	@GetMapping("/attendance")
	public List<Attendance> findAll() {
		return attendanceDAO.findAll();
	}

	@GetMapping("/attendance/{volunteerId}")
	public List<Attendance> getAttendanceByVolunteerId(@PathVariable int volunteerId) {
		return attendanceDAO.getAttendanceSheetByVolunteerId(volunteerId);
	}
	
}










