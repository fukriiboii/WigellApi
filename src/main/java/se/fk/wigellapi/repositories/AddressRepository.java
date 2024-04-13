package se.fk.wigellapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.fk.wigellapi.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByStreetAndCityAndPostalCode(String street, String city, String postalCode);
}
