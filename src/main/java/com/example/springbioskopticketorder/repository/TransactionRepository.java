package com.example.springbioskopticketorder.repository;

import com.example.springbioskopticketorder.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
