package br.com.brainpower.bluebank.form;

import br.com.brainpower.bluebank.entity.Client;
import org.hibernate.annotations.NotFound;

public class AccountForm {

    @NotFound
    private String accountNumber;
    @NotFound
    private String agencyNumber;
    @NotFound
    private String agencyTelephone;
    @NotFound
    private double accountBalance;
    @NotFound
    private Client client;


    public AccountForm(String accountNumber, String agencyNumber, String agencyTelephone, double accountBalance,
                           Client client) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.agencyTelephone = agencyTelephone;
        this.accountBalance = accountBalance;
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public String getAgencyTelephone() {
        return agencyTelephone;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public Client getClient() {
        return client;
    }
}
