package com.shine.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shine.webapp.model.Person;
import com.shine.webapp.repository.PersonRepository;

@RestController
@RequestMapping("api/people")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
	public List<Person> getAllPeople() {
		return personRepository.findAll();
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
}
