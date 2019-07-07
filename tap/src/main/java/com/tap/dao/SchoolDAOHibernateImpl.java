package com.tap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tap.entity.School;

@Repository
public class SchoolDAOHibernateImpl implements SchoolDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public SchoolDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional
	public List<School> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<School> theQuery =
				currentSession.createQuery("from School", School.class);
		
		// execute query and get result list
		List<School> schools = theQuery.getResultList();
		
		// return the results		
		return schools;
	}

}







