package com.practice.spring.mvc_hibernate_aop.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees", catalog = "postgres", schema = "public")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @NotBlank
    @Size(min = 2, max = 15)
    @Column(name = "name", length = 15)
    private String name;

    @NotBlank
    @Size(min = 2, max = 15)
    @Column(name = "surname", length = 25)
    private String surname;

    @NotBlank
    @Size(min = 2, max = 15)
    @Column(name = "department", length = 20)
    private String department;

    @Column(name = "salary")
    private long salary;

}