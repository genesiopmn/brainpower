package br.com.brainpower.bluebank.repository;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Client c JOIN Account a ON c.id = a.id WHERE c.identificationDocument = :identificationDocument")
    Account findByidentificationDocument(String identificationDocument);
}
