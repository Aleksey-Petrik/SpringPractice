package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "position", catalog = "postgres", schema = "public")
public class Position {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 25)
    private String name;

    /*
    * Класс Employee ничего не знает про Position, но не наоборот. В данном случае source таблица не имеет foreign key,
    * а target имеет, но ничего нам не мешает прописать в source таблицу поле связи с target таблицей.
    * */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private List<Employee> employees;

    public void addEmployeeToPosition(Employee employee) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }
}
