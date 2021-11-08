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


/**
 * Classe para fazer conversão de entidade para DTO e de DTO para entidade
 */

public class ClientFactory {
    /**
     * Função para convert entidadde client para DTO ClientDto
     * @param client - objeto do tipo entidade
     * @return retorno de um Dto CLientDto
     */
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
        return clientDto; 
               
    }

    /**
     * Função para desabilitar um cliente
     * @param client recebe um objeto cliente do tipo entidade
     */
    public static void disableStatus(Client client){
        client.setActive(false);
    }

    /**
     * Recebe um objeto do tipo form e convert em entidade
     * @param clientForm - recebe um objeto do tipo form
     * @return retorna um objeto do entidade Client
     */
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

    /**
     * Função que atualiza o endereço do cliente
     * @param fullAddress - paramentro com o objeto do tipo fulladdress para atualizar
     * @param updateClientFullAdressForm informações novas para atualizar o cliente
     * @return retorna o cliente atualizado
     */
    public static FullAddress updateFullAdress(FullAddress fullAddress, UpdateClientFullAddressForm updateClientFullAdressForm){
        fullAddress.setZipCode(updateClientFullAdressForm.getZipCode());
        fullAddress.setAddress(updateClientFullAdressForm.getAddress());
        fullAddress.setCity(fullAddress.getCity());
        fullAddress.setCountry(updateClientFullAdressForm.getCountry());
        fullAddress.setDistrict(updateClientFullAdressForm.getDistrict());
        fullAddress.setNumber(updateClientFullAdressForm.getNumber());
        fullAddress.setState(updateClientFullAdressForm.getState());
        fullAddress.setComplement(updateClientFullAdressForm.getComplement());
        
        return fullAddress;
    }

    /**
     * Verificar o status do cliente
      * @param client recebe um cliente
     * @return retorna o status do cliente
     */ 
    public static boolean checkStatus(Client client){
        if(client.isActive()){
            return true;
        } else {
            return false;
        }
    }
}
