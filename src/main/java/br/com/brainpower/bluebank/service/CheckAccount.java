package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.exception.NoBalanceAccount;
import br.com.brainpower.bluebank.repository.AccountRepository;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.Optional;

public class CheckAccount {
    
    public static void checkAccountFindById(Optional<Account> account){
        if(account.isEmpty()){
            throw new ResourceNotFoundException("Id Not Found");
        } if(!account.get().isActive()){
            throw new ResourceNotFoundException("Id Not Found");   
        } if(!account.get().getAccountStatus()){
            throw new ResourceNotFoundException("Id Not Found");    
        }
    }
    
    public static boolean checkAccountBalance(BigDecimal value, Account originAccount, AccountRepository accountRepository, Account destinAccount){
        BigDecimal valueBalanceAccount = balanceActual(originAccount,accountRepository);
        if(value.doubleValue() > valueBalanceAccount.doubleValue()){
            throw new NoBalanceAccount("No Balance On Account");                 
        }
        subtractBalance(originAccount, accountRepository,value);
        addBalance(destinAccount,accountRepository,value);
        return true;
    }
    
    private static BigDecimal balanceActual(Account originAccount, AccountRepository accountRepository){
        return accountRepository.findByAccountValueBalance(originAccount.getId());    
    }
    
    public static void subtractBalance(Account originAccount, AccountRepository accountRepository, BigDecimal value){
        Account account = accountRepository.findById(originAccount.getId()).get();
        account.subtractAccountBalance(value);
    }
    
    public static void addBalance(Account destinAccount, AccountRepository accountRepository, BigDecimal value){
        Account account = accountRepository.findById(destinAccount.getId()).get();
        account.addAccountBalance(value);
    }
}
