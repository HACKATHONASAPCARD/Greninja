package com.hackathon.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.model.Transaction;
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

	   List <Transaction> transactions = new ArrayList<>();
	   
	   try( BufferedReader br = new BufferedReader( new FileReader(file))) {
		   String line;
		   while ((line = br.readLine()) != null ) {
	   Transaction transaction = new Transaction();
	   //Lógica para processa cada linha e preencher os campos de transação 
	   transaction.setStatus('P'); // 'P' para pendente
	   transactions.add(transaction);
		   }
	   } catch (IOException e) {
		   //Trate exceções 
		   e.printStackTrace();
	   }
	   
	   transactionRepository.saveAll(transactions);

	  }

}
