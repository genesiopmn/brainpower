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

/**
 * Classe que controla as transferencia entre contas
 */
@RestController
@RequestMapping("transaction")
public class TransactionHistoryController {
    
    @Autowired
    private TransactionHistoryService transactionHistoryService;

    /**
     * Função para fazer uma transferencia entre contas
     * @param transactionHistoryForm - formulário da transferencia de dados
     * @return retorno de um ok caso a transferencia for concretizada
     */
    @PostMapping
    public ResponseEntity saveTransactionHistoryController(@RequestBody TransactionHistoryForm transactionHistoryForm){
        transactionHistoryService.saveHistoryTransaction(transactionHistoryForm);
        return ResponseEntity.ok().build();
    }

    /**
     * Trazer todas as transferencias do cliente pela o número da conta
     * @param accountNumber - numero da conta para ser pesquisado
     * @return retorno da lista de transferencia daquele numero daquele cliente
     */
    @GetMapping(value = "account/{accountNumber}")
    public ResponseEntity<List<TransactionHistoryDto>> findByIdAccount(@PathVariable String accountNumber){
        List<TransactionHistoryDto> listTransactionDto = transactionHistoryService.findByIdAccount(accountNumber);
        return ResponseEntity.ok().body(listTransactionDto);
    }

    /**
     * Trazer todas as transferencias do cliente pelo o numero de documento de identificaçao
     * @param identificationDocument - numero para ser pesquisado
     * @return retorno da lista de transferencia daquele numero de identificaçao do documento do cliente
     */
    @GetMapping(value = "client/{identificationDocument}")
    public ResponseEntity<List<TransactionHistoryDto>> findByIdIdentificationDocument(@PathVariable String identificationDocument){
        List<TransactionHistoryDto> listTransactionDTO = transactionHistoryService.findByIdClient(identificationDocument);
        return ResponseEntity.ok().body(listTransactionDTO);
    }
}
