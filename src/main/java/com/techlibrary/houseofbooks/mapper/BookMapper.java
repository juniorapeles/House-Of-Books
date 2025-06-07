package com.techlibrary.houseofbooks.mapper;

import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.book.Book;
import com.techlibrary.houseofbooks.mapper.generic.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper extends GenericMapper<Book, BookDTO> {
}
