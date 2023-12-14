package com.techlibrary.houseofbooks.entities;

import com.techlibrary.houseofbooks.dto.BookDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "the 'name' field cannot be blank")
    private String name;
    @NotBlank(message = "the 'imgPath' field cannot be blank")
    private String imgPath;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @NotNull(message = "The 'author'  field cannot be null")
    private Author author;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "the 'publication_date' field cannot be null")
    private Date publication_date;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "the 'description' field cannot be blank")
    private String description;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    @NotNull(message = "the 'categorie' field cannot be null")
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "publishingCompany_id")
    @NotNull(message = "the 'publishingCompany' field cannot be null")
    private PublishingCompany publishingCompany;

    public Book() {
    }
    public Book(BookDTO bookDTO) {
        this.id = bookDTO.getId();
        this.name = bookDTO.getName();
        this.imgPath = bookDTO.getImgPath();
        this.author = bookDTO.getAuthor();
        this.publication_date = bookDTO.getPublication_date();
        this.description = bookDTO.getDescription();
        this.categorie = bookDTO.getCategorie();
        this.publishingCompany = bookDTO.getPublishingCompany();
    }

    public Book(Long id, String name, String imgPath, Author author, Date publication_date, String description, Categorie categorie, PublishingCompany publishingCompany) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.author = author;
        this.publication_date = publication_date;
        this.description = description;
        this.categorie = categorie;
        this.publishingCompany = publishingCompany;
    }

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
