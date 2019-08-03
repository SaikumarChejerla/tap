package com.tap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tap.entity.Student;
import com.tap.entity.Volunteer;

@Repository
public class StudentDAOHibernateImpl implements StudentDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public StudentDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Student> theQuery =
				currentSession.createQuery("from Student", Student.class);
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();
		
		// return the results		
		return students;
	}


	@Override
	public List<Student> getByVolunteer(Volunteer volunteer) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		CriteriaBuilder cb = currentSession.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		
		Predicate predicateForVertical = cb.equal(root.get("vertical"),volunteer.getVertical());
		Predicate predicateForSchool = cb.equal(root.get("school"),volunteer.getSchool());
		
		Predicate finalPredicate = cb.and(predicateForVertical, predicateForSchool);
		criteriaQuery.where(finalPredicate);

		List<Student> students = currentSession.createQuery(criteriaQuery).getResultList();
		
		return students;
	}


	
	@Override
	@Transactional
	public void saveStudent(Student student) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(student);
	}

	@Override
	@Transactional
	public Student findById(int studentid) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Student student = currentSession.get(Student.class, studentid);
		return student;
	}
}







