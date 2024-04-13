package se.fk.wigellapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.fk.wigellapi.models.Address;
import se.fk.wigellapi.repositories.AddressRepository;

import java.util.Optional;

@Service
public class AddressService implements AddressServiceInterface{

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Optional<Address> getAddresses(Long id) {
        return addressRepository.findById(id);
    }


}
