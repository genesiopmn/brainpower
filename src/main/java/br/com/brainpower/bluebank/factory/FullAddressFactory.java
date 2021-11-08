package br.com.brainpower.bluebank.factory;

import br.com.brainpower.bluebank.dto.FullAddressDto;
import br.com.brainpower.bluebank.entity.FullAddress;
import br.com.brainpower.bluebank.form.FullAddressForm;

public class FullAddressFactory {
    
    public static FullAddressDto convertFullAddressDto(FullAddress fullAddress){
        FullAddressDto fullAddressDto = new FullAddressDto();
        
        fullAddressDto.setAddress(fullAddress.getAddress());
        fullAddressDto.setCity(fullAddress.getCity());
        fullAddressDto.setComplement(fullAddress.getComplement());
        fullAddressDto.setCountry(fullAddress.getCountry());
        fullAddressDto.setId(fullAddress.getId());
        fullAddressDto.setDistrict(fullAddress.getDistrict());
        fullAddressDto.setNumber(fullAddress.getNumber());
        fullAddressDto.setState(fullAddress.getState());
        fullAddressDto.setZipCode(fullAddress.getZipCode());
        
        return fullAddressDto;
    }
    
    public static FullAddress convertFullAddress(FullAddressForm fullAddressForm){
        FullAddress fullAddress = new FullAddress();
        
        fullAddress.setAddress(fullAddressForm.getAddress());
        fullAddress.setCity(fullAddressForm.getCity());
        fullAddress.setComplement(fullAddressForm.getComplement());
        fullAddress.setCountry(fullAddressForm.getCountry());
        fullAddress.setDistrict(fullAddressForm.getDistrict());
        fullAddress.setNumber(fullAddressForm.getNumber());
        fullAddress.setZipCode(fullAddressForm.getZipCode());
        fullAddress.setState(fullAddressForm.getState());
        fullAddress.setComplement(fullAddressForm.getComplement());
        
        return fullAddress;
    }
}
