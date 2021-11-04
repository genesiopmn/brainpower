package br.com.brainpower.bluebank.controller;

import br.com.brainpower.bluebank.dto.TransactionHistoryDto;
import br.com.brainpower.bluebank.form.TransactionHistoryForm;
import br.com.brainpower.bluebank.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionHistoryController {
    
    @Autowired
    private TransactionHistoryService transactionHistoryService;
    
    @PostMapping
    public ResponseEntity saveTransactionHistoryController(TransactionHistoryForm transactionHistoryForm){
        transactionHistoryService.saveHistoryTransaction(transactionHistoryForm);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "account/{id}")
    public ResponseEntity<List<TransactionHistoryDto>> findByIdAccount(@PathVariable Integer id){
        List<TransactionHistoryDto> listTransactionDto = transactionHistoryService.findByIdAccount(id);
        return ResponseEntity.ok().body(listTransactionDto);
    }
    
    @GetMapping(value)
}
