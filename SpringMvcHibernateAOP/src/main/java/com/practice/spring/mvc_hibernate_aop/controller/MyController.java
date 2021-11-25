package com.practice.spring.mvc_hibernate_aop.controller;

import com.practice.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.practice.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/allEmployees")
    public String showAllEmployees(Model model) {

        List<Employee> employees = employeeDAO.getAllEmployees();
        model.addAttribute("employees", employees);
        return "all-employees";
    }

}