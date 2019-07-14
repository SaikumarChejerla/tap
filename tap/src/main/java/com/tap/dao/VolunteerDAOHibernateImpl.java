package com.tap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tap.entity.Volunteer;

@Repository
public class VolunteerDAOHibernateImpl implements VolunteerDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public VolunteerDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional
	public List<Volunteer> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Volunteer> theQuery =
				currentSession.createQuery("from Volunteer", Volunteer.class);
		
		// execute query and get result list
		List<Volunteer> volunteers = theQuery.getResultList();
		
		// return the results		
		return volunteers;
	}


	@Override
	public Volunteer getById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		return currentSession.get(Volunteer.class, id);
	}

}







