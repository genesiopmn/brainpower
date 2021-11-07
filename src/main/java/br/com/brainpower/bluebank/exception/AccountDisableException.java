package br.com.brainpower.bluebank.exception;

/**
 * Exceção de conta desabilitada
 */
public class AccountDisableException extends RuntimeException{

    public AccountDisableException(String message) {
        super("Account Disable " + message);
    }
}
