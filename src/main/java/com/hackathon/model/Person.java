package com.hackathon.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table( name = "tb_person")
public class Person {
	
	@Id
	private String id; 
	
	private String name;
	
	private int age;
	
	
	
}

	


