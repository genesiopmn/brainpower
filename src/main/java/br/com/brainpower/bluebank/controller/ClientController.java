package br.com.brainpower.bluebank.controller;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> findByIdClient(@PathVariable UUID id){
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);        
    }
}
