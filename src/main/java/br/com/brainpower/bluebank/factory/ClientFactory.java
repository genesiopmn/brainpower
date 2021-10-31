package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.form.ClientForm;
import br.com.brainpower.bluebank.form.UpdateClientFullAdressForm;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;

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
        
        if(!checkStatus(client)){
            throw new ResourceNotFoundException("id not found");
        }
        return clientDto;
    }
    
    public static void disableStatus(Client client){
        client.setActive(false);
    }
    
    public static Client convertClient(ClientForm clientForm){
        Client client = new Client();
        client.setBirthdate(clientForm.getBirthdate());
        client.setEmail(clientForm.getEmail());
        client.setFulladdress(clientForm.getFulladdress());
        client.setTelephone(clientForm.getTelephone());
        client.setIdentificationDocument(clientForm.getIdentificationDocument());
        client.setName(clientForm.getName());
        
        return client;
    }
    
    public static Client updateFullAdress(Client client, UpdateClientFullAdressForm updateClientFullAdressForm){
        client.setFulladdress(updateClientFullAdressForm.getFulladdress());
        
        return client;
    }
    
    public static boolean checkStatus(Client client){
        if(client.isActive()){
            return true;
        } else {
            return false;
        }
    }
}
