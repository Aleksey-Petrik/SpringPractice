package com.practice.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String showInfoForEmployees() {
        return "view_for_all_employees";
    }

    @GetMapping("/hr_info")
    public String showInfoForHR() {
        return "view_for_hr";
    }

    @GetMapping("/manager_info")
    public String showInfoForManagers() {
        return "view_for_managers";
    }
}
