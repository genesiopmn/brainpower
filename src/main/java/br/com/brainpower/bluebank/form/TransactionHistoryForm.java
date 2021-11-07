package br.com.brainpower.bluebank.form;

import java.math.BigDecimal;

public class TransactionHistoryForm {
    
    private Integer idOriginAccount;
    private Integer idDestinationAccount;
    private BigDecimal value;
    private String historic;

    public TransactionHistoryForm(Integer idOriginAccount, Integer idDestinationAccount, BigDecimal value, String historic) {
        this.idOriginAccount = idOriginAccount;
        this.idDestinationAccount = idDestinationAccount;
        this.value = value;
        this.historic = historic;
    }

    public TransactionHistoryForm(Integer idOriginAccount, Integer idDestinationAccount, BigDecimal value) {
        this.idOriginAccount = idOriginAccount;
        this.idDestinationAccount = idDestinationAccount;
        this.value = value;
    }
    
    public TransactionHistoryForm(){}

    public Integer getIdOriginAccount() {
        return idOriginAccount;
    }

    public Integer getIdDestinationAccount() {
        return idDestinationAccount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getHistoric() {
        return historic;
    }
}
