package se.fk.wigellapi.services;

import se.fk.wigellapi.models.Address;

import java.util.Optional;

public interface AddressServiceInterface {
    Optional<Address> getAddresses(Long id);
}
