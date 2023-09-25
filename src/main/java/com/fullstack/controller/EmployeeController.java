package com.fullstack.controller;

import com.fullstack.entities.Employee;
import com.fullstack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "empId")long empId){
        employeeService.deleteEmployeeById(empId);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "empId")long empId,
                                                    @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.updateEmployee(empId,employee));
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name = "empId")long empId){
        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
