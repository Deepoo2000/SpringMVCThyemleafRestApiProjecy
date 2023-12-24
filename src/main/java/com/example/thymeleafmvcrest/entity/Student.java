package com.example.thymeleafmvcrest.entity;

import com.example.thymeleafmvcrest.customannotationforvalidation.EmailValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotNull(message = "is required")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "is required")
    private String lastName;

    @Column(name="email")
    @NotNull(message = "is required")
    @EmailValidation
    private String email;

    public Student() {
    }
}
