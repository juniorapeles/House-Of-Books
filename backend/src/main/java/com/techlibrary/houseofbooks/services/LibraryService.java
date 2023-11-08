package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository repository;

}
