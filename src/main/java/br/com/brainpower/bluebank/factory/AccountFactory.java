package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.AccountDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.Client;
import br.com.brainpower.bluebank.form.AccountForm;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;

public class AccountFactory {

    public static AccountDto convertAccountDto(Account account){
        AccountDto accountDto = new AccountDto();

        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAgencyNumber(account.getAgencyNumber());
        accountDto.setAgencyTelephone(account.getAgencyTelephone());
        accountDto.setAccountBalance(account.getAccountBalance());
        accountDto.setId(account.getId());
        accountDto.setAccountStatus(account.getAccountStatus());
        
        
        

        if(!checkStatus(account)){
            throw new ResourceNotFoundException("id not found");
        }
        return accountDto;
    }

    public static Account convertAccountForm(AccountForm accountForm){
        Account account = new Account();
        account.setAccountNumber(accountForm.getAccountNumber());
        account.setAgencyNumber(accountForm.getAgencyNumber());
        account.setAgencyTelephone(accountForm.getAgencyTelephone());
        account.setAccountBalance(accountForm.getAccountBalance());

        return account;
    }

    public static boolean checkStatus(Account account){
        if(account.isActive()) return true;
        return false;
    }

    public static void disableStatus(Account account){
        account.setActive(false);
    }
}
