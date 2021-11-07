package br.com.brainpower.bluebank.controller;

import br.com.brainpower.bluebank.dto.TransactionHistoryDto;
import br.com.brainpower.bluebank.form.TransactionHistoryForm;
import br.com.brainpower.bluebank.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionHistoryController {
    
    @Autowired
    private TransactionHistoryService transactionHistoryService;
    
    @PostMapping
    public ResponseEntity saveTransactionHistoryController(@RequestBody TransactionHistoryForm transactionHistoryForm, UriComponentsBuilder uriBuilder){
        transactionHistoryService.saveHistoryTransaction(transactionHistoryForm);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "account/{accountNumber}")
    public ResponseEntity<List<TransactionHistoryDto>> findByIdAccount(@PathVariable String accountNumber){
        List<TransactionHistoryDto> listTransactionDto = transactionHistoryService.findByIdAccount(accountNumber);
        return ResponseEntity.ok().body(listTransactionDto);
    }
    
    @GetMapping(value = "client/{identificationDocument}")
    public ResponseEntity<List<TransactionHistoryDto>> findByIdIdentificationDocument(@PathVariable String identificationDocument){
        List<TransactionHistoryDto> listTransactionDTO = transactionHistoryService.findByIdClient(identificationDocument);
        return ResponseEntity.ok().body(listTransactionDTO);
    }
}
