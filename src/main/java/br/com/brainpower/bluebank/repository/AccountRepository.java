package br.com.brainpower.bluebank.repository;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAllByClient(Client client);
}
