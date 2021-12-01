package com.practice.spring.client.rest;

import com.practice.spring.client.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/SpringRestMVC/api/Employees";

    public List<Employee> getEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
                });
        return responseEntity.getBody();
    }

    public Employee getEmployee(long id) {
        Employee employee = restTemplate.getForObject(URL.concat("/" + id), Employee.class);
        /*second variant for return employee responseEntity.getBody()
        ResponseEntity<Employee> responseEntity = restTemplate.exchange(URL.concat("/" + id), HttpMethod.GET, null,
                new ParameterizedTypeReference<Employee>() {
                });
         */
        return employee;

    }

    public void saveEmployee(Employee employee) {
        if (employee.getId() == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
        }
    }

    public void deleteEmployee(long id) {
        restTemplate.delete(URL.concat("/" + id));
    }
}
