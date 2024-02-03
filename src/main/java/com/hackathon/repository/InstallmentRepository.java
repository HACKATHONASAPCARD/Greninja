package com.hackathon.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.model.Installment;

public interface InstallmentRepository extends JpaRepository <Installment, UUID> {

}
