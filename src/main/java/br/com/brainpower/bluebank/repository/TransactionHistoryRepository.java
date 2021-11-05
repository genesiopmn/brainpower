package br.com.brainpower.bluebank.repository;

import br.com.brainpower.bluebank.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {
}
