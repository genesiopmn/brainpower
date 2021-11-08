package br.com.brainpower.bluebank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Classe Data Transfer Object (DTO) para a Transferencia Bancaria
 */
public class TransactionHistoryDto {
    
    private LocalDateTime date;                                  
    private String historic;
    private BigDecimal value;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHistoric() {
        return historic;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
