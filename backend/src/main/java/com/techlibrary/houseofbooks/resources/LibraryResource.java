package com.techlibrary.houseofbooks.resources;

import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.services.BookService;
import com.techlibrary.houseofbooks.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/libraries")
public class LibraryResource {

	@Autowired
	private LibraryService service;




}
