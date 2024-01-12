package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.AddressDTO;
import com.techlibrary.houseofbooks.repositories.BookRepository;
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
public class BookServiceTest {

    @InjectMocks
    private BookService service;

    @Mock
    private BookRepository addressRepository;

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
            service.DeleteBook(nonExistingID);
        });

    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            service.DeleteBook(existingID);
        });

        Mockito.verify(addressRepository, Mockito.times(1)).deleteById(existingID);
    }
}

