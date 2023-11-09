package com.techlibrary.houseofbooks.dto;

import java.util.Date;
import java.util.List;

public class LoanRequestDTO {
    private Long bookId;
    private Long userId;

    private List<Long> bookIds;
    private Date dueDate;

    public LoanRequestDTO() {
    }

    public LoanRequestDTO(Long bookId, Long userId, List<Long> bookIds, Date dueDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.bookIds = bookIds;
        this.dueDate = dueDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
