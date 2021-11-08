package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.AccountDto;
import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.form.AccountForm;

/**
 * Classe para fazer conversão de entidade para DTO e de DTO para entidade
 */
public class AccountFactory {

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
        
        ClientDto clientDto = ClientFactory.convertClientDto(account.getClient());
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
        account.setAccountBalance(accountForm.getAccountBalance());
        account.setClient(client);

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
