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

/**
 * Controller para o caminho /account. No controller possui funções de listar tudo, por id e por documento de identificação. Deletar uma conta,
 * habilitar e desabilitar a conta
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService service;

    /**
     * Função para trazer todas as contas e retornar no formato Jason para o Front-end.
     * @Return - uma resposta com todas as contas encontradas no banco de dados.
     */
    @GetMapping
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    /**        
     * Função para trazer uma conta por id.
     * @param id - id da conta gerado pelo o banco de dados
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDto> findByIdAccount(@PathVariable Integer id){
        AccountDto accountDto = service.findById(id);
        return ResponseEntity.ok(accountDto);
    }

    /**
     * Função para trazer todas as contas pelo o documento de identificação do próprio cliente
     * @param identificationDocument - documento de identificação do cliente
     * @return retorno uma lista com todas as contas do cliente com esse número de identificação 
     */
    @GetMapping(value = "/identificationDocument/{identificationDocument}")
    public ResponseEntity<AccountDto> findAllByClientIdentificationDocument(@PathVariable String identificationDocument){
        return ResponseEntity.ok(service.findAllByIdentificationDocument(identificationDocument));
    }

    /**
     * Função para deletar uma conta por id
     * @param id - id da conta
     * @return - retorno ok caso a conta seja excluída
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        service.removeById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Função com o objetivo de cadastrar uma nova conta
     * @param form formulário com as informações de cadastro
     * @param uriBuilder URL de retorno da API
     * @return retorno do cliente criado
     */
    @PostMapping
    public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountForm form, UriComponentsBuilder uriBuilder){
        AccountDto accountDto = service.saveAccount(form);
        URI uri = uriBuilder.path("/account/{id}").buildAndExpand(accountDto.getId()).toUri();
        return ResponseEntity.created(uri).body(accountDto);
    }

    /**
     * Função para desabilitar uma conta, caso o cliente queira fechar a conta.
     * @param id - id da conta.
     * @return - retorno ok caso o processo de fechamento da conta esteja salvo.
     */
    @PutMapping (value = "disabled/{id}")
    public ResponseEntity disableAccountById(@PathVariable Integer id){
        service.disableAccountById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Função para habilitar uma conta, caso o cliente queira reabrir a conta.
     * @param id - id da conta
     * @return - retorno ok caso o processo de reabertura da conta.
     */
    @PutMapping(value = "/reactive/{id}")
    public ResponseEntity reactivateAccountById(@PathVariable Integer id){
        service.reactivateAccountById(id);
        return ResponseEntity.ok().build();
    }
}
