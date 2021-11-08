package br.com.brainpower.bluebank.config;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;

import br.com.brainpower.bluebank.entity.FullAddress;
import br.com.brainpower.bluebank.entity.TransactionHistory;
import br.com.brainpower.bluebank.repository.AccountRepository;
import br.com.brainpower.bluebank.repository.ClientRepository;
import br.com.brainpower.bluebank.repository.FullAddressRepository;
import br.com.brainpower.bluebank.repository.TransactionHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private FullAddressRepository fullAddressRepository;     
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;
    
    @Override
    public void run(String... args) throws Exception {

        Client client1 = new Client("Laura","1234567899","laura@gmail.com","1182734628", 
                LocalDate.of(2000,10,20));

        Account account1 = new Account("14831-0","7908","11-983743819", new BigDecimal("5000"), client1);

        Client client2 = new Client("Laura","1234567898","laura@gmail.com","1182734628",
                LocalDate.of(2000,10,20));

        Account account2 = new Account("14832-0","7908","11-983743819", new BigDecimal("5000"), client2);

        Client client3 = new Client("Laura","1234567897","laura@gmail.com","1182734628",
                LocalDate.of(2000,10,20));

        Account account3 = new Account("14833-0","7908","11-983743819", new BigDecimal("5000"), client3);

        Client client4 = new Client("Laura","1234567896","laura@gmail.com","1182734628",
                LocalDate.of(2000,10,20));

        Account account4 = new Account("14834-0","7908","11-983743819", new BigDecimal("5000"), client4);

        Client client5 = new Client("Laura","1234567895","laura@gmail.com","1182734628",
                LocalDate.of(2000,10,20));

        Account account5 = new Account("14835-0","7908","11-983743819", new BigDecimal("5000"), client5);
        
        account5.setActive(false);
        account1.setAccountStatus(false);

        FullAddress fullAddress = new FullAddress();
        fullAddress.setAddress("Rua Rodolfo");
        fullAddress.setComplement("Casa 03");
        fullAddress.setState("São Paulo");
        fullAddress.setDistrict("SP");
        fullAddress.setNumber(500);
        fullAddress.setCountry("Brasil");
        fullAddress.setZipCode("03584-130");
        client2.addListFullAddress(fullAddress);
        fullAddress.setClient(client2);
        

        TransactionHistory transactionHistory = new TransactionHistory("TESTE PRIMEIRA TRANSFERENCIA",new BigDecimal("5001"),account1,account2);
        //fullAddressRepository.save(fullAddress);
        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
        clientRepository.save(client4);
        clientRepository.save(client5);
        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);
        accountRepository.save(account4);
        accountRepository.save(account5);
        transactionHistoryRepository.save(transactionHistory);

    }
}
