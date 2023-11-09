package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Book;

import java.util.Date;
import java.util.List;
public class LoanDTO {
    private Long id;
    private Date startDate;
    private Date dueDate;
    private String status;
    private Long userId;
    private Long bookId;

    public LoanDTO(){
    }

    public LoanDTO(Long id, Date startDate, Date dueDate, String status, Long userId, Long bookId) {
        this.id = id;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = status;
        this.userId = userId;
        this.bookId = bookId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
