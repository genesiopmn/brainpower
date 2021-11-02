package br.com.brainpower.bluebank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fulladdress")
public class FullAddress extends SuperEntity{
    
    private String address;
    private int number;
    private String complement;
    private String district;
    private String city;
    private String zipCode;
    private String state;
    private String country;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    public FullAddress(String address, int number, String complement, String district, String city, String zipCode, String state, String country, Client client) {
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }

    public FullAddress(String address, int number, String district, String city, String zipCode, String state, String country, Client client) {
        this.address = address;
        this.number = number;
        this.district = district;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.client = client;
    }
    
    public FullAddress(){}

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Client getClient() {
        return client;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
