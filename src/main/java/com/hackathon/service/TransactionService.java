package com.hackathon.service;


import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hackathon.repository.InstallmentRepository;
import com.hackathon.repository.PersonRepository;
import com.hackathon.repository.TransactionRepository;

@Service 
public class TransactionService {
	  @Autowired
	   private PersonRepository personRepository;
	  
	   @Autowired 
	   private TransactionRepository transactionRepository;

	   @Autowired
	   private InstallmentRepository installmentReposiroty;

	 public void processFile( File file) {

	   
	  }

}
