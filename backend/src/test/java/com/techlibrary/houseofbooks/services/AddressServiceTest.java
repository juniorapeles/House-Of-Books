package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
public class AddressServiceTest {

    @InjectMocks
    private AddressService service;

    @Mock
    private AddressRepository addressRepository;

    private long existingID;
    private long nonExistingID;

    @BeforeEach
    public void setUp() throws Exception {

        AddressDTO adressDTO = new AddressDTO();
        existingID = 1L;
        nonExistingID = 2L;

       Mockito.doNothing().when(addressRepository).deleteById(existingID);
       Mockito.doThrow(ResourceNotFoundException.class).when(addressRepository).deleteById(nonExistingID);

    }



    @Test
    public void findByidShouldReturnNotFoundWhenIdDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.deleteAddress(nonExistingID);
        });

    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            service.deleteAddress(existingID);
        });

        Mockito.verify(addressRepository, Mockito.times(1)).deleteById(existingID);
    }
}

