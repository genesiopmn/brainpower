package br.com.brainpower.bluebank.repository;

import br.com.brainpower.bluebank.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository TransactionHistory.
 */
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {
    
    @Query("SELECT t FROM TransactionHistory t JOIN Account a ON t.origin.id = a.id WHERE a.accountNumber = :accountNumber")
    List<TransactionHistory> findByIdAccount(String accountNumber);
    
    @Query("SELECT t FROM TransactionHistory t JOIN Account a on t.origin.id = a.id JOIN Client c ON a.client = c.id")
    List<TransactionHistory> findByIdentificationDocument(String identificationDocument);
}
