package com.techlibrary.houseofbooks.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    @NotBlank(message = "the 'name' field cannot be blank")
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "loan_relationship",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> loanedBooks = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User(String password) {
        this.password = password;
    }

    public Set<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(Set<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(UUID userId, String username, String password, Set<Book> loanedBooks, Set<Role> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.loanedBooks = loanedBooks;
        this.roles = roles;
    }

    public UUID getUserId() {
        return userId;
    }

    public @NotBlank(message = "the 'name' field cannot be blank") String getUsername() {
        return username;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUsername(@NotBlank(message = "the 'name' field cannot be blank") String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public enum Values {
        ADMIN(1L),
        BASIC(2L);

        private final long userId;

        Values(long userId) {
            this.userId = userId;
        }

        public long getUserId() {
            return userId;
        }
    }
}
