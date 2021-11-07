package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.TransactionHistoryDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.TransactionHistory;
import br.com.brainpower.bluebank.form.TransactionHistoryForm;

import java.util.List;

public class TransactionHistoryFactory {
    
    public static TransactionHistory convertTransactionHistory(TransactionHistoryForm transactionHistoryForm, Account originAccount, Account destinAccount){
        TransactionHistory transactionHistory = new TransactionHistory(transactionHistoryForm.getValue(),originAccount,destinAccount);
        transactionHistory.setHistory(transactionHistoryForm.getHistoric());
        return transactionHistory;
    }
    
    public static TransactionHistoryDto convertTransactionHistoryDto(TransactionHistory transactionHistory){
        TransactionHistoryDto transactionHistoryDto = new TransactionHistoryDto();
        
        transactionHistoryDto.setHistoric(transactionHistory.getHistory());
        transactionHistoryDto.setDate(transactionHistory.getDate());
        transactionHistoryDto.setValue(transactionHistory.getValue());
        
        return transactionHistoryDto;
    } 
}
