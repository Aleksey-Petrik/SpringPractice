package com.practice.spring.mvc_hibernate_aop.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "employees", catalog = "postgres", schema = "public")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", length = 15)
    private String name;

    @Column(name = "surname", length = 25)
    private String surname;

    @Column(name = "department", length = 20)
    private String department;

    @Column(name = "salary")
    private BigDecimal salary;

}