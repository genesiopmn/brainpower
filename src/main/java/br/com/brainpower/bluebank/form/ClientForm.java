package br.com.brainpower.bluebank.form;


import org.hibernate.annotations.NotFound;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<FullAddressForm> listFulladdress = new ArrayList<>();

    public ClientForm(String name, String identificationDocument, String email, LocalDate birthdate) {
        this.name = name;
        this.identificationDocument = identificationDocument;
        this.email = email;
        this.birthdate = birthdate;
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

    public List<FullAddressForm> getListFulladdress() {
        return listFulladdress;
    }
    
    public void addListFullAddressForm(FullAddressForm fullAddressForm){
        this.listFulladdress.add(fullAddressForm);
    } 
}
