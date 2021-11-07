package br.com.brainpower.bluebank.repository;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Client c JOIN Account a ON c.id = a.id WHERE c.identificationDocument = :identificationDocument")
    Account findByidentificationDocument(String identificationDocument);
    
    @Query("SELECT a.accountBalance FROM Account a WHERE a.id = :id")
    BigDecimal findByAccountValueBalance(Integer id);
}
