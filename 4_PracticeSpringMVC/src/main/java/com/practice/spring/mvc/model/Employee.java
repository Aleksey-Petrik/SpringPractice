package com.practice.spring.mvc.model;

import com.practice.spring.mvc.validation.CheckEmail;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    @Size(min = 2, message = "name must be min 2 symbols!")
    private String name;
    @NotBlank
    private String surname;
    @Min(500)
    private double salary;
    private String department;
    private String carBrand;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{2}", message = "format xxx-xxx-xx")
    private String phoneNumber;
    @CheckEmail(value = "@mail.com", message = "email mast ends with mail.com")
    private String email;

    private Map<String, String> departments = new HashMap<>();
    private Map<String, String> carBrands = new HashMap<>();
    private Map<String, String> languageList = new HashMap<>();

    private String[] languages;

    public Employee() {
        departments.put("IT", "Information Technology");
        departments.put("HR", "Human Resources");
        departments.put("Sales", "Sales");

        carBrands.put("LADA", "LADA");
        carBrands.put("OPEL", "OPEL");
        carBrands.put("BMW", "BMW");

        languageList.put("English", "EN");
        languageList.put("Deutch", "DE");
        languageList.put("French", "FR");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Map<String, String> languageList) {
        this.languageList = languageList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", salary=" + salary + ", department='" + department + '\'' + '}';
    }
}
