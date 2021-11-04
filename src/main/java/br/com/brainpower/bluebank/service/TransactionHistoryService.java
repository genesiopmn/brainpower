package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.TransactionHistory;
import br.com.brainpower.bluebank.factory.TransactionHistoryFactory;
import br.com.brainpower.bluebank.form.TransactionHistoryForm;
import br.com.brainpower.bluebank.repository.AccountRepository;
import br.com.brainpower.bluebank.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionHistoryService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;
    
    public void saveHistoryTransaction(TransactionHistoryForm transactionHistoryForm){
        Optional<Account> originAccountOptional = accountRepository.findById(transactionHistoryForm.getIdOriginAccount());
        Optional<Account> destinAccountOptional = accountRepository.findById(transactionHistoryForm.getIdDestinationAccount());
        CheckAccount.checkAccount(originAccountOptional);
        Account originAccount = originAccountOptional.get();
        CheckAccount.checkAccount(destinAccountOptional);
        Account destinAccount = destinAccountOptional.get();
        
        TransactionHistory transactionHistory = TransactionHistoryFactory.convertTransactionHistory(transactionHistoryForm,originAccount,destinAccount);
        transactionHistoryRepository.save(transactionHistory);
    }     
}
