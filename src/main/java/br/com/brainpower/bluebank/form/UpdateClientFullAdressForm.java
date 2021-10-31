package br.com.brainpower.bluebank.form;

import com.sun.istack.NotNull;

public class UpdateClientFullAdressForm {
    
    @NotNull
    private String fulladdress;

    public String getFulladdress() {
        return fulladdress;
    }

    public void setFulladdress(String fulladdress) {
        this.fulladdress = fulladdress;
    }
}
