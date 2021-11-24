package com.practice.spring.mvc;

import com.practice.spring.mvc.validation.CheckEmail;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    @Size(min = 2, message = "Min count 2 symbol!")
    private String firstName;
    //@NotEmpty(message = "Not Null!!!")
    @NotBlank(message = "Not Null!!!")
    private String lastName;
    @Min(value = 500, message = ">= 500")
    @Max(value = 1000, message = "<= 1000")
    private double salary;
    private String department;
    private String carBrand;
    private String[] languages;
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "xxx-xx-xx")
    private String phoneNumber;
    @CheckEmail(value = "zyx.com")
    private String email;
    private Map<String, String> departments;
    private Map<String, String> carBrands;
    private Map<String, String> listLanguages;

    public Employee() {
        departments = new HashMap<>();
        departments.put("IT", "Information Technology");
        departments.put("HR", "Human Resources");
        departments.put("Sales", "Sales");

        carBrands = new HashMap<>();
        carBrands.put("BMW", "BMW");
        carBrands.put("OPEL", "OPEL");
        carBrands.put("MB", "Mercedes-Benz");

        listLanguages = new HashMap<>();
        listLanguages.put("EN", "English");
        listLanguages.put("DE", "Deutsch");
        listLanguages.put("FR", "French");
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

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public Map<String, String> getListLanguages() {
        return listLanguages;
    }

    public void setListLanguages(Map<String, String> listLanguages) {
        this.listLanguages = listLanguages;
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
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

}