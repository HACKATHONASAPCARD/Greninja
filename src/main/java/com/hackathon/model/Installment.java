package com.hackathon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "tb_installment")

public class Installment {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;

	private String installment_number;

	private int value;

	@ManyToOne
	@JsonIgnoreProperties("installment")
	private Transaction transaction;

	

}
