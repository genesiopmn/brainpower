package br.com.brainpower.bluebank.entity;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Client extends SuperEntity{
    
    private String name;
    private String identificationDocument;
    private String email;
    private String telephone;
    private LocalDate birthdate;
    private String fulladdress;
    private boolean acceptStorageLgpd;

    public Client(String name, String identificationDocument, String email, String telephone, LocalDate birthdate, String fulladdress) {
        super();
        this.name = name;
        this.identificationDocument = identificationDocument;
        this.email = email;
        this.telephone = telephone;
        this.birthdate = birthdate;
        this.fulladdress = fulladdress;
        this.acceptStorageLgpd = true;
    }
    public Client (){}    

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

    public boolean isAcceptStorageLgpd() {
        return acceptStorageLgpd;
    }
}
