package com.hackathon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_transaction")
public class Transaction {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotBlank(message = "Atributo data de transação é obrigatório")
	private String date;

	@NotBlank(message = "Atributo valor da transação é obrigatório")
	private int amount;

	@ManyToOne
	@JsonIgnoreProperties("transaction")
	private Person person;

	@ManyToOne
	@JsonIgnoreProperties("transaction")
	private Installment installment;

	
}
