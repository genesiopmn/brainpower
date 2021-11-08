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
    public ResponseEntity<ClientDto> findByIdClient(@PathVariable Integer id){
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);        
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        clientService.removeById(id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientForm form, UriComponentsBuilder uriBuilder){
        ClientDto clientDto = clientService.save(form);
        URI uri = uriBuilder.path("/clients/{id}").buildAndExpand(clientDto.getId()).toUri();
        return ResponseEntity.created(uri).body(clientDto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Integer id, @RequestBody UpdateClientFullAdressForm updateClientFullAdressForm){
        ClientDto clientDto = clientService.updateFullAdress(updateClientFullAdressForm,id);
        return ResponseEntity.ok(clientDto);
    }
}
