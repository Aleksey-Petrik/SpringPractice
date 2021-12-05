package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stat", catalog = "postgres", schema = "todolist")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(includeFieldNames = false, of = {"id", "completedTotal", "uncompletedTotal"})
public class Stat {//Общая статистика по задачам, одна запись на пользователя
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "completed_total", updatable = false)//данное поле вычисляется автоматически в триггерах базы данных, поэтому обновление не нужно
    private long completedTotal;
    @Column(name = "uncompleted_total", updatable = false)//данное поле вычисляется автоматически в триггерах базы данных, поэтому обновление не нужно
    private long uncompletedTotal;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
