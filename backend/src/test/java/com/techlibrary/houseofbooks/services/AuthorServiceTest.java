package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.repositories.AuthorRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    private AuthorService service;

    @Mock
    private AuthorRepository addressRepository;

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
            service.deleteAuthor(nonExistingID);
        });

    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            service.deleteAuthor(existingID);
        });

        Mockito.verify(addressRepository, Mockito.times(1)).deleteById(existingID);
    }
}

