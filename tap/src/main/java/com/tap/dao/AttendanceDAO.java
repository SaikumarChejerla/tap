package com.tap.dao;

import java.util.List;

import com.tap.entity.Attendance;

public interface AttendanceDAO {

	public List<Attendance> findAll();
	
	public List<Attendance> getAttendanceSheetByVolunteerId(int id);
		
}
