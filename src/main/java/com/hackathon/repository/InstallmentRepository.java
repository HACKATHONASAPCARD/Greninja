package com.hackathon.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.model.Installment;

@Repository 
public interface InstallmentRepository extends JpaRepository <Installment, UUID> {

}
