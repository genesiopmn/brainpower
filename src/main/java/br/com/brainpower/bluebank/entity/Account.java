package br.com.brainpower.bluebank.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account extends SuperEntity{

    private String accountNumber;
    private String agencyNumber;
    private String agencyTelephone;
    private double accountBalance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    private boolean accountStatus = true;

    public Account(String accountNumber, String agencyNumber, String agencyTelephone, double accountBalance,
                   Client client) {
        super();
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.agencyTelephone = agencyTelephone;
        this.accountBalance = accountBalance;
        this.client = client;
    }

    public Account(){}

    public String getAccountNumber() {

        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {

        this.accountNumber = accountNumber;
    }

    public String getAgencyNumber() {

        return agencyNumber;
    }

    public void setAgencyNumber(String agencyNumber) {

        this.agencyNumber = agencyNumber;
    }

    public double getAccountBalance() {

        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {

        this.accountBalance = accountBalance;
    }

    public String getAgencyTelephone() {
        return agencyTelephone;
    }

    public void setAgencyTelephone(String agencyTelephone) {
        this.agencyTelephone = agencyTelephone;
    }

    public boolean getAccountStatus() {
        return accountStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
