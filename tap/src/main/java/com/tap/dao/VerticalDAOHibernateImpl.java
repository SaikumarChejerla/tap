package com.tap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tap.entity.Vertical;

@Repository
public class VerticalDAOHibernateImpl implements VerticalDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public VerticalDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional
	public List<Vertical> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Vertical> theQuery =
				currentSession.createQuery("from Vertical", Vertical.class);
		
		// execute query and get result list
		List<Vertical> verticals = theQuery.getResultList();
		
		// return the results		
		return verticals;
	}

}







