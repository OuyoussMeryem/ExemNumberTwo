package com.example.springbootappexem.controllers;

import com.example.springbootappexem.models.Employee;
import com.example.springbootappexem.repositories.EmployeeRepo;
import com.example.springbootappexem.repositories.ProjectRepo;
import com.example.springbootappexem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeControlleur {


    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("employees", employees);
        return "employeeList";
    }
    @DeleteMapping("/remove/{id}")
    public String removeEmployee(@PathVariable Long id) {
        Employee employee = employeeRepo.findById(id).orElse(null);
        if (employee != null) {
            employeeRepo.delete(employee);
        }
        return "redirect:/employee/list";
    }

    @PostMapping("/affecter")
    public String assignProjectToEmployee(@ModelAttribute Employee employee) {
        Employee existingEmployee = employeeRepo.findById(employee.getId()).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setProjects(employee.getProjects());
            employeeRepo.save(existingEmployee);
        }
        return "redirect:/employee/employeeList";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Employee employee = employeeService.login(username, password);
        if (employee != null) {

            return "redirect:/home";
        } else {

            return "redirect:/login?error=true";
        }
    }

    @PostMapping("/register")
    public String register(Employee employee) {
        employeeService.register(employee);

        return "redirect:/login";
    }



}
