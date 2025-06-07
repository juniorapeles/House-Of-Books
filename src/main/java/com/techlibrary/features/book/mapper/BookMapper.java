package com.techlibrary.features.book.mapper;

import com.techlibrary.features.book.dto.BookDTO;
import com.techlibrary.features.book.domain.Book;
import com.techlibrary.generics.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper extends GenericMapper<Book, BookDTO> {

}