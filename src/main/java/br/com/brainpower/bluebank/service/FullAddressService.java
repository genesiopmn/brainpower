package br.com.brainpower.bluebank.service;

import br.com.brainpower.bluebank.dto.FullAddressDto;
import br.com.brainpower.bluebank.entity.FullAddress;
import br.com.brainpower.bluebank.factory.ClientFactory;
import br.com.brainpower.bluebank.factory.FullAddressFactory;
import br.com.brainpower.bluebank.form.UpdateClientFullAddressForm;
import br.com.brainpower.bluebank.repository.FullAddressRepository;
import br.com.brainpower.bluebank.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FullAddressService {
    
    @Autowired
    private FullAddressRepository fullAddressRepository;
    
    public List<FullAddressDto> findByAll(){
        return fullAddressRepository.findAll().stream().map(FullAddressFactory::convertFullAddressDto).collect(Collectors.toList());
    }
    
    public void saveFullAddress(List<FullAddress> listFullAddress){
        for(FullAddress fullAddress : listFullAddress){
            fullAddressRepository.save(fullAddress);
        }
    }

    public FullAddressDto updateFullAddress(UpdateClientFullAddressForm updateClientFullAdressForm, Integer id){
        Optional<FullAddress> fullAddressOptional= fullAddressRepository.findById(id);
        if(fullAddressOptional.isEmpty()){
            throw new ResourceNotFoundException(id);
        }
        FullAddress fullAddress = fullAddressOptional.get();
        FullAddress fullAddressUpdate = updateFullAdress(fullAddress,updateClientFullAdressForm);
        fullAddressUpdate.setUpdatedAt(LocalDateTime.now());
        fullAddressRepository.save(fullAddressUpdate);
        return FullAddressFactory.convertFullAddressDto(fullAddressUpdate);
    }

    private static FullAddress updateFullAdress(FullAddress fullAddress, UpdateClientFullAddressForm updateClientFullAdressForm){
        fullAddress.setAddress(updateClientFullAdressForm.getAddress());
        fullAddress.setComplement(updateClientFullAdressForm.getComplement());
        fullAddress.setState(updateClientFullAdressForm.getState());
        fullAddress.setDistrict(updateClientFullAdressForm.getDistrict());
        fullAddress.setNumber(updateClientFullAdressForm.getNumber());
        fullAddress.setCountry(updateClientFullAdressForm.getCountry());
        fullAddress.setCity(updateClientFullAdressForm.getCity());
        fullAddress.setZipCode(updateClientFullAdressForm.getZipCode());

        return fullAddress;
    }
}
