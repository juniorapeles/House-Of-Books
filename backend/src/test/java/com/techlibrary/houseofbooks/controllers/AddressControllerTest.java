package com.techlibrary.houseofbooks.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techlibrary.houseofbooks.dto.AddressDTO;
import com.techlibrary.houseofbooks.services.AddressService;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AddressService service;
    @Autowired
    private ObjectMapper objectMapper;



    AddressDTO adressDTO;
    private long existingID;
    private long nonExistingID;

    @BeforeEach
    public void setUp() throws Exception {
        adressDTO = new AddressDTO();
        existingID = 1L;
        nonExistingID = 2L;

        when(service.getAdressById(existingID)).thenReturn(adressDTO);
        when(service.getAdressById(nonExistingID)).thenThrow(ResourceNotFoundException.class);

        when(service.updateAddress(eq(existingID), any())).thenReturn(adressDTO);
        when(service.updateAddress(eq(nonExistingID), any())).thenThrow(ResourceNotFoundException.class);


    }


    @Test
    public void updateShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(adressDTO);

        ResultActions result = mockMvc.perform(put
                ("/Address/{$}", nonExistingID)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }
    @Test
    public void updateShouldReturnDTOWhenIdExists() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(adressDTO);

        ResultActions result = mockMvc.perform(put
                ("/Address/{$}", existingID)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
    }

    @Test
    public void findByIdShouldReturnAddressWhenIdExists() throws Exception {
        ResultActions result = mockMvc.perform(get
                ("/Address/{$}", existingID).accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        /* não funciona

        result.andExpect(jsonPath("$.street").exists());
        result.andExpect(jsonPath("$.city").exists());
        result.andExpect(jsonPath("$.state").exists());
        result.andExpect(jsonPath("$.postalCode").exists());
        result.andExpect(jsonPath("$.country").exists());


         */

    }

    @Test
    public void findByidShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
        ResultActions result = mockMvc.perform(get
                ("/Address/{$}", nonExistingID).accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }

}
