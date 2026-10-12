package com.vcube.empportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.empportal.model.Employee;
import com.vcube.empportal.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // GET: http://localhost:9999/getEmpList
    @GetMapping("/getEmpList")
    List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    // GET: http://localhost:9999/getEmp/3
    @GetMapping("/getEmp/{eid}")
    Employee getEmployee(@PathVariable Integer eid) {
        return employeeService.getEmployee(eid);
    }

    // POST: http://localhost:9999/createEmp
    @PostMapping("/createEmp")
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // PUT: http://localhost:9999/updateEmp/3
    @PutMapping("/updateEmp/{eid}")
    Employee updateEmployee(
            @RequestBody Employee employee,
            @PathVariable Integer eid) {
        return employeeService.updateEmployee(employee, eid);
    }

    // DELETE: http://localhost:9999/delEmp/3
    @DeleteMapping("/delEmp/{eid}")
    String deleteEmployee(@PathVariable Integer eid) {
        return employeeService.deleteEmployee(eid);
    }
}