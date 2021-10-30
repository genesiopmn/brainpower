package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.factory.ClientFactory;
import br.com.brainpower.bluebank.repository.ClientRepository;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<ClientDto> findAll(){
        return clientRepository.findAll().stream().map(ClientFactory::convertClientDto).collect(Collectors.toList());
    }
    
    public ClientDto findById(UUID id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        Client client = clientOptional.get();
        return ClientFactory.convertClientDto(client);
    }
}
