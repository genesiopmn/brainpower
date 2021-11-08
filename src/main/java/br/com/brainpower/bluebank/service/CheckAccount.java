package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.entity.Account;
import br.com.brainpower.bluebank.exception.NoBalanceAccount;
import br.com.brainpower.bluebank.repository.AccountRepository;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Classe que verifica se a classe está ativa
 */
public class CheckAccount {

    /**
     * verifica a conta se está ativa pelo o id
     * @param account - recebe um Optional de conta
     */
    public static void checkAccountFindById(Optional<Account> account){
        if(account.isEmpty()){
            throw new ResourceNotFoundException("Id Not Found");
        } if(!account.get().isActive()){
            throw new ResourceNotFoundException("Id Not Found");   
        } if(!account.get().getAccountStatus()){
            throw new ResourceNotFoundException("Id Not Found");    
        }
    }

    /**
     * Função com objetivo de verificar se a conta tem saldo
     * @param value valor a ser transferido
     * @param originAccount conta a ser debitada
     * @param accountRepository - objeto que faz a comunicação com o banco de dados
     * @param destinAccount - conta a ser creditada
     * @return  retorna verdeira caso a conta passe por todas a verificações.
     */
    public static boolean checkAccountBalance(BigDecimal value, Account originAccount, AccountRepository accountRepository, Account destinAccount){
        BigDecimal valueBalanceAccount = balanceActual(originAccount,accountRepository);
        if(value.doubleValue() > valueBalanceAccount.doubleValue()){
            throw new NoBalanceAccount("No Balance On Account");                 
        }
        subtractBalance(originAccount, accountRepository,value);
        addBalance(destinAccount,accountRepository,value);
        return true;
    }

    /**
     * Função Methodo para fazer a transferencia 
     * @param originAccount Conta de Origem a ser debitada
     * @param accountRepository objeto que faz a comunicação com o banco de dados 
     * @return retorna o resultado das funções.
     */
    private static BigDecimal balanceActual(Account originAccount, AccountRepository accountRepository){
        return accountRepository.findByAccountValueBalance(originAccount.getId());    
    }

    /**
     * Subtrai o valor da conta de origem
     * @param originAccount Conta de origem a ser debitada
     * @param accountRepository Objeto que faz a comunicação com o banco de dados
     * @param value valor a ser debitado
     */
    public static void subtractBalance(Account originAccount, AccountRepository accountRepository, BigDecimal value){
        Account account = accountRepository.findById(originAccount.getId()).get();
        account.subtractAccountBalance(value);
    }

    /**
     * Função que adiciona valor na conta de destino
     * @param destinAccount Conta de destino a ser creditada
     * @param accountRepository Objeto que faz a comunicação com o banco de dados
     * @param value valor a ser creditado
     */
    public static void addBalance(Account destinAccount, AccountRepository accountRepository, BigDecimal value){
        Account account = accountRepository.findById(destinAccount.getId()).get();
        account.addAccountBalance(value);
    }
}
