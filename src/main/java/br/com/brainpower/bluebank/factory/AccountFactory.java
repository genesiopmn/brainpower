package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.AccountDto;
import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.form.AccountForm;
import br.com.brainpower.bluebank.service.ClientService;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe para fazer conversão de entidade para DTO e de DTO para entidade
 */
public class AccountFactory {
    
    @Autowired
    private ClientService clientService;

    /**
     * Função para convert entidadde Account para DTO AccountDto
     * @param account - objeto do tipo entidade
     * @return retorno de um Dto AccountDto
     */
    public static AccountDto convertAccountDto(Account account){
        AccountDto accountDto = new AccountDto();

        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAgencyNumber(account.getAgencyNumber());
        accountDto.setAgencyTelephone(account.getAgencyTelephone());
        accountDto.setAccountBalance(account.getAccountBalance());
        accountDto.setId(account.getId());
        accountDto.setAccountStatus(true);       
        
        Client client = account.getClient();      
        
        ClientDto clientDto = ClientFactory.convertClientDto(client);
        accountDto.setClient(clientDto);
        return accountDto;
    }

    /**
     * Função para converter de um objeto do tipo Form para Entidade
     * @param accountForm - Objeto do tipo AccountForm
     * @return retorno de um Account Entidade
     */
    public static Account convertAccountForm(AccountForm accountForm){
        Account account = new Account();
        account.setAccountNumber(accountForm.getAccountNumber());
        account.setAgencyNumber(accountForm.getAgencyNumber());
        account.setAgencyTelephone(accountForm.getAgencyTelephone());

        return account;
    }

    /**
     * Função que verifica de o status da conta está ativo
     * @param account recebe um account
     * @return retorno verdadeiro se a conta está disponível e false se não estiver disponível
     */
    public static boolean checkStatus(Account account){
        if(account.isActive()){
            return true;
        } else {
            return false;    
        }        
    }

    /**
     * Função para desabilitar a conta
     * @param account objeto do tipo entidade
     */
    public static void disableStatus(Account account){
        account.setActive(false);
    }
}           
