package com.fullstack.service;

import com.fullstack.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    //To add Employee
    Employee addEmployee(Employee employee);

    //To Delete Employee
    String deleteEmployeeById(long empId);

    //To update Employee
    Employee updateEmployee(long empId,Employee employee);

    //To get employee by id
    Employee getEmployeeById(long empId);

    //To get all Employees

    List<Employee> getAllEmployees();
}
