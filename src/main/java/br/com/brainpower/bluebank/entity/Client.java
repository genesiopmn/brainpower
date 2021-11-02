package br.com.brainpower.bluebank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends SuperEntity{
    
    private String name;
    private String identificationDocument;
    private String email;
    private String telephone;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy/MM/dddd")
    private LocalDate birthdate;
    private boolean acceptStorageLgpd;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<FullAddress> listFullAddress = new ArrayList<>();

    public Client(String name, String identificationDocument, String email, String telephone, LocalDate birthdate) {
        this.name = name;
        this.identificationDocument = identificationDocument;
        this.email = email;
        this.telephone = telephone;
        this.birthdate = birthdate;
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

    public List<FullAddress> getListFullAddress() {
        return listFullAddress;
    }
    
    public void addListFullAddress(FullAddress fullAddress){
        this.listFullAddress.add(fullAddress);
    }

    public void setListFullAddress(List<FullAddress> listFullAddress) {
        this.listFullAddress = listFullAddress;
    }
}
