package br.com.brainpower.bluebank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactionHistory")
public class TransactionHistory extends SuperEntity{
    
    private String history;
    private LocalDateTime date = LocalDateTime.now();
    private BigDecimal value;
    
    @ManyToOne
    @JoinColumn(name = "origin_accountId")
    @JsonIgnore
    private Account origin;
    @ManyToOne
    @JoinColumn(name = "destination_accountId")
    @JsonIgnore
    private Account destination;
    
    public TransactionHistory(){}

    public TransactionHistory(String history, BigDecimal value, Account origin, Account destination) {
        this.history = history;
        this.value = value;
        this.origin = origin;
        this.destination = destination;
    }

    public TransactionHistory(BigDecimal value, Account origin, Account destination) {
        this.value = value;
        this.origin = origin;
        this.destination = destination;
    }

    public String getHistory() {
        return history;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Account getOrigin() {
        return origin;
    }

    public Account getDestination() {
        return destination;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
