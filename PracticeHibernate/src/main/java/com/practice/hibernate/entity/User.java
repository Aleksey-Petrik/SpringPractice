package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = false, of = {"id", "userName", "userPassword", "email"})
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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Category> categories;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Priority> priorities;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Activity activity;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
