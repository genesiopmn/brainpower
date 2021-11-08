package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.AccountDto;
import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.form.AccountForm;

public class AccountFactory {

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

    public static Account convertAccountForm(AccountForm accountForm, Client client){
        Account account = new Account();
        account.setAccountNumber(accountForm.getAccountNumber());
        account.setAgencyNumber(accountForm.getAgencyNumber());
        account.setAgencyTelephone(accountForm.getAgencyTelephone());
        account.setAccountBalance(accountForm.getAccountBalance());
        account.setClient(client);

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
