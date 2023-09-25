package com.fullstack.service.impl;

import com.fullstack.entities.Employee;
import com.fullstack.exception.ResourceNotFoundException;
import com.fullstack.repository.EmployeeRepository;
import com.fullstack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }

    @Override
    public String deleteEmployeeById(long empId) {
        Employee employee=employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
        employeeRepository.deleteById(empId);
        return "Employee Deleted successfully...";
    }

    @Override
    public Employee updateEmployee(long empId, Employee employee) {
        Employee updateEmployee=employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
        updateEmployee.setName(employee.getName());
        updateEmployee.setCity(employee.getCity());
        updateEmployee.setDesignation(employee.getDesignation());
        updateEmployee.setSalary(employee.getSalary());
        Employee newUpdatedEmployee = employeeRepository.save(updateEmployee);
        return newUpdatedEmployee;
    }

    @Override
    public Employee getEmployeeById(long empId) {
        Employee employee=employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }
}
