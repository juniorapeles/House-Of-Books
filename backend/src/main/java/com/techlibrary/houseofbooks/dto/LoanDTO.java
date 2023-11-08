package com.techlibrary.houseofbooks.dto;

import java.util.Date;
import java.util.List;
public class LoanDTO {
    private Long id;
    private Date startDate;
    private Date dueDate;
    private String status;
    private UserDTO user;
    private List<Book> books;

    public LoanDTO() {
    }

    public LoanDTO(Long id, Date startDate, Date dueDate, String status, UserDTO user, List<Book> books) {
        this.id = id;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = status;
        this.user = user;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
