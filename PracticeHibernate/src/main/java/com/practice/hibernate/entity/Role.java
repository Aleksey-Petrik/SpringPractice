package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role_data", catalog = "postgres", schema = "todolist")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(includeFieldNames = false, of = {"id", "name"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

}