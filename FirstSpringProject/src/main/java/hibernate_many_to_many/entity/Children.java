package hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "children")
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "children_hobby",
            joinColumns = @JoinColumn(name = "children_id"),//Прописываем поле с помощью которого происходит связь таблиц children и children_hobby
            inverseJoinColumns = @JoinColumn(name = "hobby_id")//Прописываем поле с помощью которого происходит связь таблиц children и hobby
    )
    private List<Hobby> hobbies;

    public Children() {
    }

    public Children(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addHobby(Hobby hobby) {
        if (hobbies == null) {
            hobbies = new ArrayList<>();
        }
        hobbies.add(hobby);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Children children = (Children) o;
        return id == children.id && age == children.age && Objects.equals(name, children.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Children{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
