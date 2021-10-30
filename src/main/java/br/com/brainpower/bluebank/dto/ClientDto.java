package br.com.brainpower.bluebank.dto;

import java.time.LocalDate;
import java.util.UUID;

public class ClientDto {
    
    private UUID id;
    private String name;
    private String identificationDocument;
    private String email;
    private String telephone;
    private LocalDate birthdate;
    private String fulladdress;

    public ClientDto(UUID id, String name, String identificationDocument, String email, String telephone, LocalDate birthdate, String fulladdress) {
        this.id = id;
        this.name = name;
        this.identificationDocument = identificationDocument;
        this.email = email;
        this.telephone = telephone;
        this.birthdate = birthdate;
        this.fulladdress = fulladdress;
    }
    
    public ClientDto() {}

    public void setId(UUID id) {
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

    public UUID getId() {
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
}
