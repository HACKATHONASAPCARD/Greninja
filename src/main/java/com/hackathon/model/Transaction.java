package com.hackathon.model;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "tb_transaction")
public class Transaction {
	
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	private BigDecimal amount;
	
	private String transactionDate; 

}