package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "activity", schema = "todolist", catalog = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(includeFieldNames = false, of = {"id", "uuid", "activated"})
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "activated", updatable = false)//данное поле вычисляется автоматически в триггерах базы данных, поэтому обновление не нужно
    private int activated;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}