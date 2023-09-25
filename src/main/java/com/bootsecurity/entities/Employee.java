package com.fullstack.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "designation")
    private String designation;
    @Column(name = "city")
    private String city;
    @Column(name = "salary")
    private long salary;
}
