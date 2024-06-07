package com.example.springbootappexem.services;

import com.example.springbootappexem.enums.Post;
import com.example.springbootappexem.models.Employee;
import com.example.springbootappexem.repositories.EmployeeRepo;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    public void postConstruct() {
        Employee employee = new Employee();
        employee.setPost(Post.MANAGER);
        employee.setUsername("MANAGER");
        employee.setPassword(passwordEncoder.encode("abc"));
        employeeRepo.save(employee);
    }

    public Employee login(String username, String password) {
        return employeeRepo.findByUsernameAndPassword(username, password);
    }

    public Employee register(Employee employee) {
        return employeeRepo.save(employee);
    }


}
