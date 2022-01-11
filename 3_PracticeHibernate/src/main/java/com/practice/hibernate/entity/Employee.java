package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(of = {"id", "name", "surname", "department", "salary"})
@Table(name = "employees", catalog = "postgres", schema = "public")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "department")
    private String departmentStr;
    @Column(name = "salary")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)//Указываем связь между таблицами ОДИН-К-ОДНОМУ, так же можно указать каскадный тип связи cascade
    @JoinColumn(name = "details_id")//Указываем поле по которому идет связь, @JoinColumn для source таблиц с foreign key target таблицы
    private Detail detail;

    /*
     * Если указать CascadeType.All, то при удалении работника будет удаляться департамент, что не нужно
     * */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department departmentObj;

    /*
     * При связи многие-ко-многим используется третья связующаяя таблица
     * в entity ее не прописываем, а указываем в аннотации JoinTable
     * */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "employees_skills",
            joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_skill")
    )
    private List<Skill> skills;

    public void addSkill(Skill skill) {
        if (skills == null) {
            skills = Collections.EMPTY_LIST;
        }
        skills.add(skill);
    }

}
