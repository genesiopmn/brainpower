package br.com.brainpower.bluebank.exception;

public class AccountDisableException extends RuntimeException{

    public AccountDisableException(String message) {
        super("Account Disable " + message);
    }
}
