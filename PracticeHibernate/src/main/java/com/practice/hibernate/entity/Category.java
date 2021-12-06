package com.practice.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category", catalog = "postgres", schema = "todolist")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(includeFieldNames = false, of = {"id", "title", "completedCount", "uncompletedCount"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "completed_count", updatable = false)//данное поле вычисляется автоматически в триггерах базы данных, поэтому обновление не нужно
    private long completedCount;
    @Column(name = "uncompleted_count", updatable = false)//данное поле вычисляется автоматически в триггерах базы данных, поэтому обновление не нужно
    private long uncompletedCount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")//По каким полям связывать (foreign key)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
