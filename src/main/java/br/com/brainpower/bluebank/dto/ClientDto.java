package br.com.brainpower.bluebank.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe Data Transfer Object (DTO) para o Cliente
 * 
 */
public class ClientDto {
    
    private Integer id;
    private String name;
    private String identificationDocument;
    private String email;
    private String telephone;
    private LocalDate birthdate;
    private String fulladdress;
    @JsonIgnore
    private List<AccountDto> listaccountDto = new ArrayList<>(); 

    public ClientDto(Integer id, String name, String identificationDocument, String email, String telephone, LocalDate birthdate, String fulladdress) {
        this.id = id;
        this.name = name;
        this.identificationDocument = identificationDocument;
        this.email = email;
        this.telephone = telephone;
        this.birthdate = birthdate;
        this.fulladdress = fulladdress;
    }
    
    public ClientDto() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setFulladdress(String fulladdress) {
        this.fulladdress = fulladdress;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getFulladdress() {
        return fulladdress;
    }

    public List<AccountDto> getListaccountDto() {
        return listaccountDto;
    }
    
    public void addListAccountDto(AccountDto accountDto){
        this.listaccountDto.add(accountDto);
    }
}
