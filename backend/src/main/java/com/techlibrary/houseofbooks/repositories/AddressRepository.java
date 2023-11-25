package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
