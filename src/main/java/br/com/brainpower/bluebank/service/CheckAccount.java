package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;

import java.util.Optional;

public class CheckAccount {
    
    public static void checkAccount(Optional<Account> account){
        if(account.isEmpty()){
            throw new ResourceNotFoundException("Id Not Found");
        } if(!account.get().isActive()){
            throw new ResourceNotFoundException("Id Not Found");   
        } if(!account.get().getAccountStatus()){
            throw new ResourceNotFoundException("Id Not Found");    
        }
    }
}
