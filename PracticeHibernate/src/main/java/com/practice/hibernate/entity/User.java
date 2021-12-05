package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Stat stat;

    //Собираем данные из таблицы role_data через вспомогательную таблицу,
    // так как пользователь может иметь несколько ролей
    // User    Role
    //     \  /
    //   user_role
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",//указываем таблицу посредник, Entity для нее нет
            joinColumns = @JoinColumn(name = "user_id"), //связываем user_role с текущей таблицей по полю user_id
            inverseJoinColumns = @JoinColumn(name = "role_id")) //role_id указывает на связь с Entity Role
    private Set<Role> roles;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
