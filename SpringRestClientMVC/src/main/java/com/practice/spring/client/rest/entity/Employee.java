package com.practice.spring.client.rest.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private long id;
    private String name;
    private String surname;
    private String department;
    private long salary;
}
