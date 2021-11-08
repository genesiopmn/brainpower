package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.factory.ClientFactory;
import br.com.brainpower.bluebank.form.ClientForm;
import br.com.brainpower.bluebank.repository.ClientRepository;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe com regras de negócios da entidade Cliente
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    
    @Autowired
    private FullAddressService fullAddressService;
    


    /**
     * Função que trazem todos os clientes do banco de dados
     * @return lista com todos os clientes
     */

    public List<ClientDto> findAll(){
        return clientRepository.findAll().stream().map(ClientFactory::convertClientDto).collect(Collectors.toList());
    }

    /**
     * Função que busca o cliente por id
     * @param id id do cliente que precisa ser procurado
     * @return retorna o cliente.
     */
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

    /**
     * Remove um cliente por id
     * @param id recebe um id do cliente
     */
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

    /**
     * salva um cliente no banco de dados
     * @param clientForm recebe um formulário com o cliente
     * @return retorna um cliente DTO
     */
    public ClientDto save(ClientForm clientForm){
        Client client = ClientFactory.convertClient(clientForm);
        clientRepository.save(client);
        fullAddressService.saveFullAddress(client.getListFullAddress());
        return ClientFactory.convertClientDto(client);
    }


    /**
     * Função que atualiza o endereço de entrega
     * @param updateClientFullAdressForm recebe um formulário para atualizar
     * @param id recebe o id do cliente que precisa ser atualizado
     * @return retorna um client DTO
     */
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
