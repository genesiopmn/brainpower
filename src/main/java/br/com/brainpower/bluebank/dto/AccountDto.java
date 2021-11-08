package br.com.brainpower.bluebank.dto;

import java.math.BigDecimal;

/**
 * Classe Data Transfer Object (DTO) para a Conta
 */
public class AccountDto {

    private Integer id;
    private String accountNumber;
    private String agencyNumber;
    private String agencyTelephone;
    private BigDecimal accountBalance;
    private ClientDto clientDto;
    private boolean accountStatus = true;

    public AccountDto(Integer id, String accountNumber, String agencyNumber, String agencyTelephone, BigDecimal accountBalance,
                      ClientDto clientDto) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.agencyTelephone = agencyTelephone;
        this.accountBalance = accountBalance;
        this.clientDto = clientDto;
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

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {

        this.accountBalance = accountBalance;
    }

    public String getAgencyTelephone() {

        return agencyTelephone;
    }

    public void setAgencyTelephone(String agencyTelephone) {

        this.agencyTelephone = agencyTelephone;
    }

    public ClientDto getClient() {
        return clientDto;
    }

    public void setClient(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public boolean getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
    
    
}
