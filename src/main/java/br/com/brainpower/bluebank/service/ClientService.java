package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.factory.ClientFactory;
import br.com.brainpower.bluebank.form.ClientForm;
import br.com.brainpower.bluebank.form.UpdateClientFullAdressForm;
import br.com.brainpower.bluebank.repository.ClientRepository;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<ClientDto> findAll(){
        return clientRepository.findAll().stream().map(ClientFactory::convertClientDto).collect(Collectors.toList());
    }
    
    public ClientDto findById(Integer id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()){
            throw new ResourceNotFoundException("id not found");
        }
        if(!ClientFactory.checkStatus(clientOptional.get())){
            throw new ResourceNotFoundException("id not found");    
        }
        Client client = clientOptional.get();
        return ClientFactory.convertClientDto(client);
    }
    
    public void removeById(Integer id){
        try{
            clientRepository.deleteById(id);    
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            Client client = clientRepository.findById(id).get();
            ClientFactory.disableStatus(client);
            clientRepository.save(client);
        }        
    }
    
    public ClientDto save(ClientForm clientForm){
        Client client = ClientFactory.convertClient(clientForm);
        clientRepository.save(client);
        return ClientFactory.convertClientDto(client);
    }
    
    public ClientDto updateFullAdress(UpdateClientFullAdressForm updateClientFullAdressForm, Integer id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()){
            throw new ResourceNotFoundException(id);
        }
        Client client = clientOptional.get();
        Client clientUpdate = ClientFactory.updateFullAdress(client, updateClientFullAdressForm);
        clientUpdate.setUpdatedAt(LocalDateTime.now());
        clientRepository.save(clientUpdate);                                                                  
        return ClientFactory.convertClientDto(clientUpdate);
    }
}
