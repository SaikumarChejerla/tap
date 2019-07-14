package com.tap.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tap.entity.Attendance;
import com.tap.entity.Student;

@Repository
public class AttendanceDAOHibernateImpl implements AttendanceDAO {

	// define field for entitymanager
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private VolunteerDAO volunteerDAO;
	
	@Autowired
	private StudentDAO studentDAO;
		
	/*@Autowired
	public AttendanceDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}*/
	
	
	@Override
	@Transactional
	public List<Attendance> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Attendance> theQuery =
				currentSession.createQuery("from Attendance", Attendance.class);
		
		// execute query and get result list
		List<Attendance> attendance = theQuery.getResultList();
		
		// return the results		
		return attendance;
	}


	@Override
	public List<Attendance> getAttendanceSheetByVolunteerId(int id) {
		
		List<Student> students = studentDAO.getByVolunteer(volunteerDAO.getById(id));
		
		List<Attendance> attendance = new ArrayList<>();
		
		for(Student student: students) {
			attendance.add(new Attendance(student,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),false,false,false));
		}
		
		return attendance;
		
	}

}







