package com.practice.spring.mvc_hibernate_aop.controller;

import com.practice.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.practice.spring.mvc_hibernate_aop.entity.Employee;
import com.practice.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;//Обращаемся к сервису, который в свою очередь обратится к DAO и попросит данные

    @RequestMapping("/allEmployees")
    public String showAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/allEmployees";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(@RequestParam("empId") int employeeId, Model model) {
        Employee employee = employeeService.getEmployee(employeeId);
        model.addAttribute(employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/allEmployees";
    }
}