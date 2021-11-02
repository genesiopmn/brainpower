package br.com.brainpower.bluebank.entity;

import br.com.brainpower.bluebank.enums.AccountStatusEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Account extends SuperEntity{

    private String accountNumber;
    private String agencyNumber;
    private String agencyTelephone;
    private double accountBalance;
    @ManyToOne
    private Client client;
    @Enumerated(value = EnumType.STRING)
    private AccountStatusEnum accountStatus;

    public Account(String accountNumber, String agencyNumber, String agencyTelephone, double accountBalance,
                   Client client, AccountStatusEnum accountStatus) {
        super();
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.agencyTelephone = agencyTelephone;
        this.accountBalance = accountBalance;
        this.client = client;
        this.accountStatus = accountStatus;
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
}
