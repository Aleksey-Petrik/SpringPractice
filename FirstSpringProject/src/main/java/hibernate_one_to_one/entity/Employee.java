package hibernate_one_to_one.entity;


import javax.persistence.*;

@Entity
@Table(name = "employees_course")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private Double salary;
    /* foreign key поле не указываем, при каскадном обновлении заполнится автоматически
        @Column(name = "details_id")
        private int detailsId;
     */
    @OneToOne(cascade = CascadeType.ALL)//Связь между таблица один-к-одному, с каскадным типом подчинения
    @JoinColumn(name = "details_id")//Аннотация объединения таблиц по столбцу "details_id"
    private Detail employeeDetail;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String department, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Detail getEmployeeDetails() {
        return employeeDetail;
    }

    public void setEmployeeDetails(Detail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", employeeDetail=" + employeeDetail +
                '}';
    }
}
