package br.com.brainpower.bluebank.exception;

/**
 * Exceção da conta sem saldo
 */
public class NoBalanceAccount extends RuntimeException{
    public NoBalanceAccount(String message) {
        super("No Balance On Account" + message);
    }
}
