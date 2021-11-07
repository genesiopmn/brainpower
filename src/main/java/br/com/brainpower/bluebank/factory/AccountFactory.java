package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.AccountDto;
import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.form.AccountForm;
import br.com.brainpower.bluebank.service.ClientService;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountFactory {
    
    @Autowired
    private ClientService clientService;

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

    public static Account convertAccountForm(AccountForm accountForm){
        Account account = new Account();
        account.setAccountNumber(accountForm.getAccountNumber());
        account.setAgencyNumber(accountForm.getAgencyNumber());
        account.setAgencyTelephone(accountForm.getAgencyTelephone());

        return account;
    }

    public static boolean checkStatus(Account account){
        if(account.isActive()){
            return true;
        } else {
            return false;    
        }        
    }

    public static void disableStatus(Account account){
        account.setActive(false);
    }
}
