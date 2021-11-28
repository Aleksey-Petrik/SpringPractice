package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "postgres")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    //@Basic
    @Column(name = "username", nullable = false, length = -1)
    private String userName;
    //@Basic
    @Column(name = "userpassword", nullable = false, length = -1)
    private String userPassword;
    //@Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
}
