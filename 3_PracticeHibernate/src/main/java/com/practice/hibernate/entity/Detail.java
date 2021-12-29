package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(of = {"id", "city", "phone_number", "email"})
@Table(name = "details", catalog = "postgres", schema = "public")
public class Detail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "city")
    private String city;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "email")
    private String email;

    /*
     * Если бы не было поля employee в данном классе, то связь с таблицей employees была бы Uni, так как employee знает про detail,
     * но в данном случае связь будет считаться BI так как оба объекта знают друг о друге.
     * */
    @OneToOne(mappedBy = "detail",//Тем самым говорим, что связь между классами имеет и в создаваемом объекте есть ссылка на текущий, указывая поле
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Employee employee;
}
