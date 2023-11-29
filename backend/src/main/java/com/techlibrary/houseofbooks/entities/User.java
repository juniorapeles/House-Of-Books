package com.techlibrary.houseofbooks.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Rg;
    private String email;
    private String telephone;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
