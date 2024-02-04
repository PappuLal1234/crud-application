package com.crud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Email is required")
    @Column(unique = true)
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
    private String gender;
    private String status;
}
