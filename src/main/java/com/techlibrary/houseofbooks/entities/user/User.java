package com.techlibrary.houseofbooks.entities.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_user")
public class User {

    @Id
    private Long id;
    private String name;
    private String secret;

}
