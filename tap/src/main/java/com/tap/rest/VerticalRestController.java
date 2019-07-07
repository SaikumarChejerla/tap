package com.tap.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.dao.VerticalDAO;
import com.tap.entity.Vertical;

@RestController
@RequestMapping("/api")
public class VerticalRestController {

	private VerticalDAO verticalDAO;
	
	@Autowired
	public VerticalRestController(VerticalDAO theVerticalDAO) {
		verticalDAO = theVerticalDAO;
	}
	
	// expose "/verticals" and return list of employees
	@GetMapping("/verticals")
	public List<Vertical> findAll() {
		return verticalDAO.findAll();
	}

	
}










