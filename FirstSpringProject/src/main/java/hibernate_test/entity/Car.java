package hibernate_test.entity;
//Аннотации JPA, правила, а hibernate реализация этих правил
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//говорит о том что у нас отображение с БД
@Table(name="cars")//класс имеет связь с указанной таблицей
public class Car {
    @Id//primary key
    @Column(name="car_id")//связь столбца из БД с полем класса
    private int id;
    @Column(name="car_model")
    private String model;
    @Column(name="car_description")
    private String description;

    public Car() {
    }

    public Car(int id, String model, String description) {
        this.id = id;
        this.model = model;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
