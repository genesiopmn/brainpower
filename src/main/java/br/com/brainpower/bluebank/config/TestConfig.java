package br.com.brainpower.bluebank.config;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.enums.AccountStatusEnum;
import br.com.brainpower.bluebank.repository.AccountRepository;
import br.com.brainpower.bluebank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Override
    public void run(String... args) throws Exception {

        Client client1 = new Client("Laura","1234567899","laura@gmail.com","1182734628", 
                LocalDate.of(2000,10,20),"Avenida 1234");

        Account account = new Account("14831-0","7908","11-983743819", 5000, client1, AccountStatusEnum.ACTIVE);
        
        clientRepository.save(client1);
        accountRepository.save(account);
    }
}
