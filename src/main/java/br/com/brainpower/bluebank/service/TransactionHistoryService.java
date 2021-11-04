package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.dto.TransactionHistoryDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.TransactionHistory;
import br.com.brainpower.bluebank.factory.TransactionHistoryFactory;
import br.com.brainpower.bluebank.form.TransactionHistoryForm;
import br.com.brainpower.bluebank.repository.AccountRepository;
import br.com.brainpower.bluebank.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;
    
    public void saveHistoryTransaction(TransactionHistoryForm transactionHistoryForm){
        Optional<Account> originAccountOptional = accountRepository.findById(transactionHistoryForm.getIdOriginAccount());
        Optional<Account> destinAccountOptional = accountRepository.findById(transactionHistoryForm.getIdDestinationAccount());
        CheckAccount.checkAccountFindById(originAccountOptional);
        Account originAccount = originAccountOptional.get();
        CheckAccount.checkAccountFindById(destinAccountOptional);
        Account destinAccount = destinAccountOptional.get();
        
        if(CheckAccount.checkAccountBalance(transactionHistoryForm.getValue(),originAccount,accountRepository,destinAccount)){
            TransactionHistory transactionHistory = TransactionHistoryFactory.convertTransactionHistory(transactionHistoryForm,originAccount,destinAccount);
            transactionHistoryRepository.save(transactionHistory);    
        }        
    }
    
    public List<TransactionHistoryDto> findByIdAccount(Integer id){
        List<TransactionHistory> listTransactionHistory = transactionHistoryRepository.findByIdAccount(id);
        return listTransactionHistory.stream().map(TransactionHistoryFactory::convertTransactionHistoryDto).collect(Collectors.toList());
    }
    
    public List<TransactionHistoryDto> findByIdClient(Integer id){
        List<TransactionHistory> listTransactionHistory = transactionHistoryRepository
    }
}
