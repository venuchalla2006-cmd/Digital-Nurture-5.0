package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("START - getAllEmployees REST");
        List<Employee> list = employeeService.getAllEmployees();
        LOGGER.info("END - getAllEmployees REST");
        return list;
    }

    // Update Employee
    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START - updateEmployee REST: {}", employee.getId());
        employeeService.updateEmployee(employee);
        LOGGER.info("END - updateEmployee REST");
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        LOGGER.info("START - deleteEmployee REST: {}", id);
        employeeService.deleteEmployee(id);
        LOGGER.info("END - deleteEmployee REST");
    }
}
