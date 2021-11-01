package br.com.brainpower.bluebank.form;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.NotFound;

import java.time.LocalDate;

public class ClientForm {
    
    @NotFound
    private String name;
    @NotFound
    private String identificationDocument;
    @NotFound
    private String email;
    private String telephone;
    @NotFound
    private LocalDate birthdate;
    @NotFound
    private String fulladdress;

    public ClientForm(String name, String identificationDocument, String email, LocalDate birthdate, String fulladdress) {
        this.name = name;
        this.identificationDocument = identificationDocument;
        this.email = email;
        this.birthdate = birthdate;
        this.fulladdress = fulladdress;
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
