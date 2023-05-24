package com.example.EmpSystem.service;

import com.example.EmpSystem.entity.Employee;
import com.example.EmpSystem.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepo repo;

    public void addEmp(Employee e) {
        repo.save(e);
    }

    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }
}
