package com.example.springbootappexem.repositories;

import com.example.springbootappexem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByUsernameAndPassword(String username, String password);
    Employee findByUsername(String username);
}
