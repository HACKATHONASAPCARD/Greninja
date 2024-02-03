package com.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.model.Person;

public interface PersonRepository extends JpaRepository <Person, String > {

}
