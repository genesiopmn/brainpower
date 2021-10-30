package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Client;

public class ClientFactory {
    
    public static ClientDto convertClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        
        clientDto.setName(client.getName());
        clientDto.setBirthdate(client.getBirthdate());
        clientDto.setEmail(client.getEmail());
        clientDto.setFulladdress(client.getFulladdress());
        clientDto.setId(client.getId());
        clientDto.setIdentificationDocument(client.getIdentificationDocument());
        clientDto.setTelephone(client.getTelephone());
        
        return clientDto;
    }
}
