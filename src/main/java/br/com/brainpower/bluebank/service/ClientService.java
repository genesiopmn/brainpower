package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.factory.ClientFactory;
import br.com.brainpower.bluebank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<ClientDto> findAll(){        
        List<Client> listClientGetBase = clientRepository.findAll();
        List<ClientDto> listClientDto = new ArrayList<>();
        for(Client client : listClientGetBase){
            ClientDto clientDto = ClientFactory.convertClientDto(client);
            listClientDto.add(clientDto);    
        }
        
        return listClientDto;
    }
}
