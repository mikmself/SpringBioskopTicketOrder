package com.example.springbioskopticketorder.service;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Transaction;
import com.example.springbioskopticketorder.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public ApiResponse<Transaction> saveTransaction(Transaction transaction) {
        try {
            Transaction savedTransaction = repository.save(transaction);
            return new ApiResponse<>(HttpStatus.OK.value(), "Transaction saved successfully", savedTransaction);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving transaction: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Transaction>> saveTransactions(List<Transaction> transactions) {
        try {
            List<Transaction> savedTransactions = repository.saveAll(transactions);
            return new ApiResponse<>(HttpStatus.OK.value(), "Transactions saved successfully", savedTransactions);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving transactions: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Transaction>> getTransactions() {
        try {
            List<Transaction> transactionList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Transactions retrieved successfully", transactionList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving transactions: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Transaction> getTransactionById(int id) {
        try {
            Transaction transaction = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Transaction retrieved successfully", transaction);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving transaction: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteTransaction(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Transaction removed successfully", "Transaction removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting transaction: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Transaction> updateTransaction(Transaction transaction) {
        try {
            Transaction existingTransaction = repository.findById(transaction.getId_transaction()).orElse(null);
            existingTransaction.setBooking_id(transaction.getBooking_id());
            existingTransaction.setTotal_payment(transaction.getTotal_payment());
            existingTransaction.setPayment_method(transaction.getPayment_method());
            return new ApiResponse<>(HttpStatus.OK.value(), "Transaction updated successfully", repository.save(existingTransaction));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating transaction: " + e.getMessage(), null);
        }
    }
}
