package br.com.brainpower.bluebank.form;

import br.com.brainpower.bluebank.entity.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;

import java.math.BigDecimal;

public class AccountForm {

    @NotFound
    private String accountNumber;
    @NotFound
    private String agencyNumber;
    @NotFound
    private String agencyTelephone;
    @NotFound
    private BigDecimal accountBalance;
    @NotFound
    private Integer client;


    public AccountForm(String accountNumber, String agencyNumber, String agencyTelephone, BigDecimal accountBalance,
                       Integer client) {
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

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public Integer getClient() {
        return client;
    }
}
