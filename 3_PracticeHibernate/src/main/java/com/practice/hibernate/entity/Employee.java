package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;

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
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)//Указываем связь между таблицами ОДИН-К-ОДНОМУ, так же можно указать каскадный тип связи cascade
    @JoinColumn(name = "details_id")//Указываем поле по которому идет связь, всегда обозначается foreign key
    private Detail detail;

    /*
     * Если указать CascadeType.All, то при удалении работника будет удаляться департамент, что не нужно
     * */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department departmentObj;
}
