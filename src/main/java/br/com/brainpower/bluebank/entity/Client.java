package br.com.brainpower.bluebank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.tomcat.jni.Local;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade Client (Mapeamento Objeto Relacional)
 */
@Entity
public class Client extends SuperEntity{
    
    private String name;
    private String identificationDocument;
    private String email;
    private String telephone;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy/MM/dddd")
    private LocalDate birthdate;
    private String fulladdress;
    private boolean acceptStorageLgpd;
    
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Account> account = new ArrayList<>();

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

    public List<Account> getAccount() {
        return account;
    }
}
