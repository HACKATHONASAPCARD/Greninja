package com.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.model.Transaction;

public interface TransactionRepository extends JpaRepository< Transaction, String> {

}
