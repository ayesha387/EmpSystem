package com.example.EmpSystem.controller;

import com.example.EmpSystem.entity.Employee;
import com.example.EmpSystem.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/")
    public String home(Model m) {

        List<Employee> emp =service.getAllEmployee();
        m.addAttribute("emp", emp);
        return "index";
    }
    @GetMapping("/addemp")
    public String addEmpForm(){
        return "add_emp";
    }
    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session){
        System.out.println(e);
        service.addEmp(e);
        session.setAttribute("msg", "Employee Added Successfully..");
        return "redirect:/";
    }
}
