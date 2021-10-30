package br.com.brainpower.bluebank.config;

import br.com.brainpower.bluebank.entity.Client;
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
    
    @Override
    public void run(String... args) throws Exception {

        Client client1 = new Client("Laura","1234567899","laura@gmail.com","1182734628", 
                LocalDate.of(2000,10,20),"Avenida 1234");
        
        clientRepository.save(client1);
    }
}
