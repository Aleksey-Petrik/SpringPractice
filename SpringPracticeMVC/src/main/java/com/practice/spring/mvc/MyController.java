package com.practice.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/employee") контроллер маппинг
public class MyController {

    @RequestMapping("/hello")//Для связывания адреса из браузера с методом
    public String showFirstView() {
        return "first-view";//возвращаем имя странички из папки view для вывода ее в браузере
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

    /*
    @RequestMapping("/showDetails")
    public String showEmpDetails(){
        return "show-emp-details-view";
    }
    */
    /*
    @RequestMapping("/showDetails")
    public String showEmpDetails(HttpServletRequest httpServletRequest, Model model) {
        String employeeName = "mr.".concat(httpServletRequest.getParameter("employeeName"));
        model.addAttribute("nameAttribute", employeeName);
        model.addAttribute("description", "super job");
        return "show-emp-details-view";
    }
    */
    /*
    @RequestMapping("/showDetails")
    //@RequestParam("employeeName") String employeeName связываем параметр с хтмл полем
    public String showEmpDetails(@RequestParam("employeeName") String employeeName, Model model) {
        employeeName = "mr.".concat(employeeName);
        model.addAttribute("nameAttribute", employeeName);
        model.addAttribute("description", "super job");
        return "show-emp-details-view";
    }
    */
    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee employee) {
        return "show-emp-details-view";
    }
}