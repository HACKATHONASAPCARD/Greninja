package com.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_person")
public class Person {

	@Id
	private Long id;

	private String name;

	private int age;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="person", cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties("person")
	
	private List<Transaction> transaction;

	

}
