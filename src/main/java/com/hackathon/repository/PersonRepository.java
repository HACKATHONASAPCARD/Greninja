package com.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.model.Person;

@Repository
public interface PersonRepository extends JpaRepository <Person, String > {

}
