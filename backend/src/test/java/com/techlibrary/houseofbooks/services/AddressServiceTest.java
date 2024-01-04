package com.techlibrary.houseofbooks.services;


import com.techlibrary.houseofbooks.repositories.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AddressServiceTest {

    @InjectMocks
    private AddressService service;

    @Mock
    private AddressRepository addressRepository;

    private long existingID;

    @BeforeEach
    public void setUp() throws Exception {
        existingID = 1L;
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            service.deleteAddress(existingID);
        });

        Mockito.verify(addressRepository, Mockito.times(1)).deleteById(existingID);
    }
}

