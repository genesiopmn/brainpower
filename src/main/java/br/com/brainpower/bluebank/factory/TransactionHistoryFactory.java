package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.TransactionHistoryDto;
import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.entity.TransactionHistory;
import br.com.brainpower.bluebank.form.TransactionHistoryForm;

import java.util.List;
/**
 * Classe para fazer conversão de entidade para DTO e de DTO para entidade
 */
public class TransactionHistoryFactory {

    /**
     * Convert de entidade o formulário e transforma em entidades
     * @param transactionHistoryForm - recebe o formulário para a transferencia
     * @param originAccount - conta de origem
     * @param destinAccount - conta de destino
     * @return retorna a entidade transaction history
     */
    public static TransactionHistory convertTransactionHistory(TransactionHistoryForm transactionHistoryForm, Account originAccount, Account destinAccount){
        TransactionHistory transactionHistory = new TransactionHistory(transactionHistoryForm.getValue(),originAccount,destinAccount);
        transactionHistory.setHistory(transactionHistoryForm.getHistoric());
        return transactionHistory;
    }

    /**
     * Função que converte de entidade para Dto
     * @param transactionHistory - recebe um TransactionHistory
     * @return retorna um dto
     */
    public static TransactionHistoryDto convertTransactionHistoryDto(TransactionHistory transactionHistory){
        TransactionHistoryDto transactionHistoryDto = new TransactionHistoryDto();
        
        transactionHistoryDto.setHistoric(transactionHistory.getHistory());
        transactionHistoryDto.setDate(transactionHistory.getDate());
        transactionHistoryDto.setValue(transactionHistory.getValue());
        
        return transactionHistoryDto;
    } 
}
