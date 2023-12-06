package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.entities.Categorie;
import com.techlibrary.houseofbooks.entities.PublishingCompany;
import jakarta.persistence.*;

import java.util.Date;


public class BookDTO {

    private Long id;
    private String name;
    private String imgPath;

    private Author author;

    private Date publication_date;

    private String description;

    private Categorie categorie;

    public BookDTO() {
    }
    public BookDTO(Book Book) {
        this.id = Book.getId();
        this.name = Book.getName();
        this.imgPath = Book.getImgPath();
        this.author = Book.getAuthor();
        this.publication_date = Book.getPublication_date();
        this.description = Book.getDescription();
        this.categorie = Book.getCategorie();
        this.publishingCompany = Book.getPublishingCompany();
    }

    public BookDTO(Long id, String name, String imgPath, Author author, Date publication_date, String description, Categorie categorie, PublishingCompany publishingCompany) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.author = author;
        this.publication_date = publication_date;
        this.description = description;
        this.categorie = categorie;
        this.publishingCompany = publishingCompany;
    }

    private PublishingCompany publishingCompany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public PublishingCompany getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(PublishingCompany publishingCompany) {
        this.publishingCompany = publishingCompany;
    }
}
