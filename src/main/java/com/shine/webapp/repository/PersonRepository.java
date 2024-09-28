package com.shine.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shine.webapp.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
