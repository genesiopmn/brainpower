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
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    /**
     * save uma transação no banco de dados
     * @param transactionHistoryForm para salvar recebe um formulário de transação
     */
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

    /**
     * Busca todas as transações por id dda conta
     * @param accountNumber recebe o número da conta 
     * @return retorno uma lista de transações
     */
    public List<TransactionHistoryDto> findByIdAccount(String accountNumber){
        List<TransactionHistory> listTransactionHistory = transactionHistoryRepository.findByIdAccount(accountNumber);
        return listTransactionHistory.stream().map(TransactionHistoryFactory::convertTransactionHistoryDto).collect(Collectors.toList());
    }

    /**
     * Função que busca todas as transações por número de identificação do cliente
     * @param identificationDocument recebe o número de identificação do cliente
     * @return retorna uma lista de transações
     */
    public List<TransactionHistoryDto> findByIdClient(String identificationDocument){
        List<TransactionHistory> listTransactionHistory = transactionHistoryRepository.findByIdentificationDocument(identificationDocument);
        return listTransactionHistory.stream().map(TransactionHistoryFactory::convertTransactionHistoryDto).collect(Collectors.toList());
    }
}
