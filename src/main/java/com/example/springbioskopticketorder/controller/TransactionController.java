package com.example.springbioskopticketorder.controller;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Transaction;
import com.example.springbioskopticketorder.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/add")
    public ApiResponse<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }

    @PostMapping("/adds")
    public ApiResponse<List<Transaction>> addTransactions(@RequestBody List<Transaction> transactions) {
        return service.saveTransactions(transactions);
    }

    @GetMapping("")
    public ApiResponse<List<Transaction>> findAllTransactions() {
        return service.getTransactions();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<Transaction> findTransactionById(@PathVariable int id) {
        return service.getTransactionById(id);
    }

    @PutMapping("/update")
    public ApiResponse<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        return service.updateTransaction(transaction);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteTransaction(@PathVariable int id) {
        return service.deleteTransaction(id);
    }
}
