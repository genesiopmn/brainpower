package br.com.brainpower.bluebank.repository;

import br.com.brainpower.bluebank.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {
    
    @Query("SELECT t FROM TransactionHistory t JOIN Account a ON t.origin.id = a.id WHERE a.id = :originAccountId")
    List<TransactionHistory> findByIdAccount(Integer originAccountId);
}
