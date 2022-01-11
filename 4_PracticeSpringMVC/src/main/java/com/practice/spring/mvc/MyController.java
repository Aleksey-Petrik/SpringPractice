package com.practice.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping("/")
    public String shoFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-employee-details-view";
    }

    /*
     * Объект модель выступает в роли транспортного контейнера, который переносит данные во view
     * HttpServletRequest параметры получаем с помощью сервлетов
     * */
/*    @GetMapping("/showDetails")
    public String showEmployeeDetails(HttpServletRequest httpRequest, Model model) {

        String employeeName = httpRequest.getParameter("employeeName");
        model.addAttribute("employeeName", employeeName);

        return "show-employee-details-view";
    }*/

    /*
     * Объект модель выступает в роли транспортного контейнера, который переносит данные во view
     * Параметры получаем с помощью spring аннотации @RequestParam
     * */
/*    @GetMapping("/showDetails")
    public String showEmployeeDetails(@RequestParam("employeeName") String employeeName, Model model) {

        model.addAttribute("employeeName", employeeName);

        return "show-employee-details-view";
    }*/

    @RequestMapping("/showDetails")
    public String showEmployeeDetails(@ModelAttribute("employee") Employee employee) {
        return "show-employee-details-view";
    }
}
