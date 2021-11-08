package br.com.brainpower.bluebank.controller;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.form.ClientForm;
import br.com.brainpower.bluebank.form.UpdateClientFullAdressForm;
import br.com.brainpower.bluebank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * Classe controladora do cliente para mandar de volta as informações do cliente
 */
@RestController
@RequestMapping("client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    /**
     * Função para trazer todos os clientes cadastrados
     * @return - retorno todos os clientes.
     */
    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    /**
     * Função para trazer o cliente pelo o seu id
     * @param id - id do cliente para ser pesquisado
     * @return - retorno do cliente para o front-end
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> findByIdClient(@PathVariable Integer id){
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);        
    }

    /**
     * Função para deletar o cliente
     * @param id - id do cliente para ser pesquisaod e deletado
     * @return retornar Ok caso consiga excluir
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        clientService.removeById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Função para cadastrar um cliente
     * @param form - recebe um formulário de clientes para ser salvo no Banco de Dados
     * @param uriBuilder - Monta uma URL para retorno do cadastro
     * @return retorna os dados gerados.
     */
    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientForm form, UriComponentsBuilder uriBuilder){
        ClientDto clientDto = clientService.save(form);
        URI uri = uriBuilder.path("/clients/{id}").buildAndExpand(clientDto.getId()).toUri();
        return ResponseEntity.created(uri).body(clientDto);
    }

    /**
     * Função para atualizar o cliente
     * @param id - id do cliente que será atualizado
     * @param updateClientFullAdressForm - formulário para atualizar o cliente
     * @return - retorna um ok caso o cleinte fosse atualizado.
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Integer id, @RequestBody UpdateClientFullAdressForm updateClientFullAdressForm){
        ClientDto clientDto = clientService.updateFullAdress(updateClientFullAdressForm,id);
        return ResponseEntity.ok(clientDto);
    }
}
