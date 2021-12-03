package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "priority", catalog = "postgres", schema = "todolist")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(includeFieldNames = false, of = {"id", "color", "title"})
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "color")
    private String color;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
