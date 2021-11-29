package com.practice.spring.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees", catalog = "postgresql", schema = "public")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = -1)
    private long id;
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Column(name = "surname", nullable = false, length = -1)
    private String surname;
    @Column(name = "department", nullable = false, length = -1)
    private String department;
    @Column(name = "salary", nullable = false, length = -1)
    private long salary;

}