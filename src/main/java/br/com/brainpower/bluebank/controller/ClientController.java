package br.com.brainpower.bluebank.controller;

import br.com.brainpower.bluebank.dto.ClientDto;
import br.com.brainpower.bluebank.dto.FullAddressDto;
import br.com.brainpower.bluebank.form.ClientForm;
import br.com.brainpower.bluebank.form.UpdateClientFullAddressForm;
import br.com.brainpower.bluebank.service.ClientService;
import br.com.brainpower.bluebank.service.FullAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @Autowired
    private FullAddressService fullAddressService; 
    
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
        URI uri = uriBuilder.path("/cars/{id}").buildAndExpand(clientDto.getId()).toUri();
        return ResponseEntity.created(uri).body(clientDto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<FullAddressDto> update(@PathVariable Integer id, @RequestBody UpdateClientFullAddressForm updateClientFullAdressForm){
        FullAddressDto fullAddressDto = fullAddressService.updateFullAddress(updateClientFullAdressForm,id);
        return ResponseEntity.ok(fullAddressDto);
    }
}
