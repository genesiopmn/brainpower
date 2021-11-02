package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.entity.FullAddress;
import br.com.brainpower.bluebank.form.ClientForm;
import br.com.brainpower.bluebank.form.FullAddressForm;
import br.com.brainpower.bluebank.form.UpdateClientFullAddressForm;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ClientFactory {
    
    public static ClientDto convertClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        
        clientDto.setName(client.getName());
        clientDto.setBirthdate(client.getBirthdate());
        clientDto.setEmail(client.getEmail());
        clientDto.setId(client.getId());
        clientDto.setIdentificationDocument(client.getIdentificationDocument());
        clientDto.setTelephone(client.getTelephone());
        for(FullAddress fullAddress : client.getListFullAddress()){
            clientDto.addFullAddressDto(FullAddressFactory.convertFullAddressDto(fullAddress));    
        }
        
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
        client.setTelephone(clientForm.getTelephone());
        client.setIdentificationDocument(clientForm.getIdentificationDocument());
        client.setName(clientForm.getName());

        List<FullAddress> listFullAddress = new ArrayList<>();
        
        for(FullAddressForm fullAddressForm : clientForm.getListFulladdress()){
            listFullAddress.add(FullAddressFactory.convertFullAddress(fullAddressForm));
        }
        
        client.setListFullAddress(listFullAddress);
        
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
