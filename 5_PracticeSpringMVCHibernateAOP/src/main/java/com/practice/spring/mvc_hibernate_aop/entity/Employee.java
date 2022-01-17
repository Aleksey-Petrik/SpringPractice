package com.practice.spring.mvc_hibernate_aop.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    
    @DecimalMin("500.00")
    @DecimalMax("10000.00")
    @Column(name = "salary")
    private BigDecimal salary;

}