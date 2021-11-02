package br.com.brainpower.bluebank.dto;

import br.com.brainpower.bluebank.enums.AccountStatusEnum;
import br.com.brainpower.bluebank.entity.Client;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

public class AccountDto {

    private Integer id;
    private String accountNumber;
    private String agencyNumber;
    private String agencyTelephone;
    private double accountBalance;
    @ManyToOne
    private Client client;
    @Enumerated(value = EnumType.STRING)
    private AccountStatusEnum accountStatus;

    public AccountDto(Integer id, String accountNumber, String agencyNumber, String agencyTelephone, double accountBalance,
                      Client client, AccountStatusEnum accountStatus) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.agencyTelephone = agencyTelephone;
        this.accountBalance = accountBalance;
        this.client = client;
        this.accountStatus = accountStatus;
    }

    public AccountDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AccountStatusEnum getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatusEnum accountStatus) {
        this.accountStatus = accountStatus;
    }
}
