package com.techlibrary.houseofbooks.services;


import com.techlibrary.houseofbooks.dto.AddressDTO;
import com.techlibrary.houseofbooks.entities.Address;
import com.techlibrary.houseofbooks.repositories.AddressRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAddress() {
        // Mocking data
        List<Address> addressList = new ArrayList<>();
        when(addressRepository.findAll()).thenReturn(addressList);

        List<Address> result = addressService.getAllAddress();

        assertEquals(addressList, result);
    }

    @Test
    public void testGetAdressById_ExistingId() {
        // Mocking data
        Long id = 1L;
        Address address = new Address();
        address.setId(id);
        when(addressRepository.findById(id)).thenReturn(Optional.of(address));

        AddressDTO result = addressService.getAdressById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testGetAdressById_NonExistingId() {
        // Mocking data
        Long id = 999L;
        when(addressRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> addressService.getAdressById(id));
    }

    @Test
    public void testCreateAddress() {
        // Mocking data
        AddressDTO addressDTO = new AddressDTO();
        Address address = new Address();
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        AddressDTO result = addressService.createAddress(addressDTO);

        assertNotNull(result);
        // Add assertions based on the logic of your method
    }

    @Test
    public void testUpdateAuthor_ExistingId() {
        // Mocking data
        Long id = 1L;
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(id);

        Address address = new Address();
        address.setId(id);

        when(addressRepository.findById(id)).thenReturn(Optional.of(address));
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        AddressDTO result = addressService.updateAuthor(id, addressDTO);

        assertNotNull(result);
        assertEquals(id, result.getId());
        // Add more assertions as needed
    }

    @Test
    public void testUpdateAuthor_NonExistingId() {
        // Mocking data
        Long id = 999L;
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(id);

        when(addressRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> addressService.updateAuthor(id, addressDTO));
    }

    @Test
    public void testDeleteAddress() {
        // Mocking data
        Long id = 1L;

        assertDoesNotThrow(() -> addressService.deleteAddress(id));
        verify(addressRepository, times(1)).deleteById(id);
    }
}

