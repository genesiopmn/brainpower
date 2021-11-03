package br.com.brainpower.bluebank.controller;

import br.com.brainpower.bluebank.dto.AccountDto;
import br.com.brainpower.bluebank.form.AccountForm;
import br.com.brainpower.bluebank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDto> findByIdAccount(@PathVariable Integer id){
        AccountDto accountDto = service.findById(id);
        return ResponseEntity.ok(accountDto);
    }
    
    @GetMapping(value = "/identificationDocument/{identificationDocument}")
    public ResponseEntity<AccountDto> findAllByClientIdentificationDocument(@PathVariable String identificationDocument){
        return ResponseEntity.ok(service.findAllByIdentificationDocument(identificationDocument));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.ok().build();
    }

    // Essa função precisa ser revista quando for mergeada na master, pois precisa do endereço
    @PostMapping
    public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountForm form, UriComponentsBuilder uriBuilder){
        AccountDto accountDto = service.saveAccount(form);
        URI uri = uriBuilder.path("/account/{id}").buildAndExpand(accountDto.getId()).toUri();
        return ResponseEntity.created(uri).body(accountDto);
    }

    @PutMapping (value = "disabled/{id}")
    public ResponseEntity disableAccountById(@PathVariable Integer id){
        service.disableAccountById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/reactive/{id}")
    public ResponseEntity reactivateAccountById(@PathVariable Integer id){
        service.reactivateAccountById(id);
        return ResponseEntity.ok().build();
    }
}
