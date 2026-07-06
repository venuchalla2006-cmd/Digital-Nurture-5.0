package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.projection.EmployeeProjection;
import com.employee.projection.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By Id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setSalary(employeeDetails.getSalary());
            if (employeeDetails.getDepartment() != null) {
                employee.setDepartment(employeeDetails.getDepartment());
            }
            Employee updatedEmployee = employeeRepository.save(employee);
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Paginated and Sorted Employees by Department (Exercise 6)
    @GetMapping("/dept/{deptId}")
    public Page<Employee> getEmployeesByDeptPaginated(
            @PathVariable Long deptId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByDepartmentId(deptId, pageable);
    }

    // Get Employees with High Salary (JPQL Query - Exercise 5)
    @GetMapping("/high-salary")
    public List<Employee> getEmployeesWithHighSalary(@RequestParam Double minSalary) {
        return employeeRepository.findEmployeesWithHighSalary(minSalary);
    }

    // Get Employees using Interface-based Projection (Exercise 8)
    @GetMapping("/projection/interface")
    public List<EmployeeProjection> getInterfaceProjections(@RequestParam Double minSalary) {
        return employeeRepository.findBySalaryGreaterThan(minSalary);
    }

    // Get Employees using Class-based DTO Projection (Exercise 8)
    @GetMapping("/projection/dto/dept/{deptId}")
    public List<EmployeeDto> getDtoProjections(@PathVariable Long deptId) {
        return employeeRepository.findEmployeeDtosByDepartmentId(deptId);
    }
}
