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

@ExtendWith(SpringExtension.class)
public class CategorieServiceTest {

    @InjectMocks
    private CategorieService service;

    @Mock
    private CategorieRepository Repository;

    private long existingID;
    private long nonExistingID;

    @BeforeEach
    public void setUp() throws Exception {

        AddressDTO adressDTO = new AddressDTO();
        existingID = 1L;
        nonExistingID = 2L;

        Mockito.doNothing().when(Repository).deleteById(existingID);
        Mockito.doThrow(ResourceNotFoundException.class).when(Repository).deleteById(nonExistingID);

    }


    @Test
    public void findByidShouldReturnNotFoundWhenIdDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.deleteCategorie(nonExistingID);
        });

    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            service.deleteCategorie(existingID);
        });

        Mockito.verify(Repository, Mockito.times(1)).deleteById(existingID);
    }
}

