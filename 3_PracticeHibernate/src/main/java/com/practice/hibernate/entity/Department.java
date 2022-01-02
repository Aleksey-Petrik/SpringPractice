package com.practice.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "departments", catalog = "postgres", schema = "public")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "max_salary")
    private Double maxSalary;
    @Column(name = "min_salary")
    private Double minSalary;

    @OneToMany(mappedBy = "departmentObj",//Ссылка на поле из класса Employee
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, //Перечень связанных действий
            fetch = FetchType.LAZY)//Тип загрузки данных ленивая или полная загрузка, по умолчанию стоит Lazy при связи one-to-many
    private List<Employee> employees;

    public void addEmployeeToDepartment(Employee employee) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }
}
