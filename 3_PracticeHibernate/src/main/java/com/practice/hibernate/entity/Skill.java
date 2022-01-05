package com.practice.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills", catalog = "postgres", schema = "public")
public class Skill {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 20)
    private String name;

    /*
     * При связи многие-ко-многим используется третья связующаяя таблица
     * в entity ее не прописываем, а указываем в аннотации JoinTable
     * */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employees_skills",
            joinColumns = @JoinColumn(name = "id_skill"),
            inverseJoinColumns = @JoinColumn(name = "id_employee"))
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        if (employees == null) {
            employees = Collections.EMPTY_LIST;
        }
        employees.add(employee);
    }
}
