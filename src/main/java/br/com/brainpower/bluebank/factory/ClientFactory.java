package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.form.ClientForm;
import br.com.brainpower.bluebank.form.UpdateClientFullAdressForm;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
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
        clientDto.setFulladdress(client.getFulladdress());
        clientDto.setId(client.getId());
        clientDto.setIdentificationDocument(client.getIdentificationDocument());
        clientDto.setTelephone(client.getTelephone());
        
        if(!checkStatus(client)){
            throw new ResourceNotFoundException("id not found");
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
        client.setFulladdress(clientForm.getFulladdress());
        client.setTelephone(clientForm.getTelephone());
        client.setIdentificationDocument(clientForm.getIdentificationDocument());
        client.setName(clientForm.getName());
        
        return client;
    }

    /**
     * Função que atualiza o endereço do cliente
     * @param client - paramentro com o objeto do tipo cliente para atualizar
     * @param updateClientFullAdressForm informações novas para atualizar o cliente
     * @return retorna o cliente atualizado
     */
    public static Client updateFullAdress(Client client, UpdateClientFullAdressForm updateClientFullAdressForm){
        client.setFulladdress(updateClientFullAdressForm.getFulladdress());
        
        return client;
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
