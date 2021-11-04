package br.com.brainpower.bluebank.exception;

public class NoBalanceAccount extends RuntimeException{
    public NoBalanceAccount(String message) {
        super("No Balance On Account" + message);
    }
}
