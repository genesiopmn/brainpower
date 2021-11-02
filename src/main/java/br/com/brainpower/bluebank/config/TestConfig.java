package br.com.brainpower.bluebank.config;

import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.entity.FullAddress;
import br.com.brainpower.bluebank.repository.ClientRepository;
import br.com.brainpower.bluebank.repository.FullAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private FullAddressRepository fullAddressRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        Client client1 = new Client("Laura","1234567899","laura@gmail.com","1182734628", 
                LocalDate.of(2000,10,20));
        FullAddress fullAddress = new FullAddress("Rua Gouveia",100,"Centro","São Paulo","00000-130","SP","Brasil",client1);
                   
        client1.addListFullAddress(fullAddress);
        clientRepository.save(client1);
        fullAddressRepository.save(fullAddress);
        
    }
}
