package com.employee;

import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.projection.EmployeeProjection;
import com.employee.projection.EmployeeDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
        System.out.println("=== Employee Management System Started Successfully ===");
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepo, DepartmentRepository deptRepo) {
        return (args) -> {
            System.out.println("\n--- Seeding Initial Data ---");
            
            // 1. Create and save departments
            Department itDept = new Department();
            itDept.setName("IT");
            deptRepo.save(itDept);

            Department hrDept = new Department();
            hrDept.setName("HR");
            deptRepo.save(hrDept);

            // 2. Create and save employees
            Employee emp1 = new Employee();
            emp1.setName("Alice");
            emp1.setEmail("alice@company.com");
            emp1.setSalary(75000.0);
            emp1.setDepartment(itDept);
            employeeRepo.save(emp1);

            Employee emp2 = new Employee();
            emp2.setName("Bob");
            emp2.setEmail("bob@company.com");
            emp2.setSalary(60000.0);
            emp2.setDepartment(itDept);
            employeeRepo.save(emp2);

            Employee emp3 = new Employee();
            emp3.setName("Charlie");
            emp3.setEmail("charlie@partner.com");
            emp3.setSalary(50000.0);
            emp3.setDepartment(hrDept);
            employeeRepo.save(emp3);

            System.out.println("Seeded 2 Departments and 3 Employees.");

            // 3. Test Auditing Fields (Exercise 7)
            System.out.println("\n--- Testing JPA Auditing (Exercise 7) ---");
            Employee savedEmp = employeeRepo.findById(emp1.getId()).orElse(null);
            if (savedEmp != null) {
                System.out.println("Employee: " + savedEmp.getName());
                System.out.println("Created By: " + savedEmp.getCreatedBy());
                System.out.println("Created Date: " + savedEmp.getCreatedDate());
            }

            // 4. Test Derived Queries (Exercise 3)
            System.out.println("\n--- Testing Derived Queries (Exercise 3) ---");
            List<Employee> itEmployees = employeeRepo.findByDepartmentId(itDept.getId());
            System.out.println("Employees in IT department (derived query):");
            itEmployees.forEach(e -> System.out.println(" - " + e.getName()));

            // 5. Test Custom @Query (Exercise 5)
            System.out.println("\n--- Testing Custom @Query min salary (Exercise 5) ---");
            List<Employee> highSalaryEmps = employeeRepo.findEmployeesWithHighSalary(55000.0);
            System.out.println("Employees with salary >= 55000:");
            highSalaryEmps.forEach(e -> System.out.println(" - " + e.getName() + " ($" + e.getSalary() + ")"));

            // 6. Test Named Queries (Exercise 5)
            System.out.println("\n--- Testing Named Queries (Exercise 5) ---");
            Employee namedQueryEmp = employeeRepo.findByEmailNamed("bob@company.com");
            System.out.println("Employee found by email using @NamedQuery: " + (namedQueryEmp != null ? namedQueryEmp.getName() : "None"));

            // 7. Test Pagination and Sorting (Exercise 6)
            System.out.println("\n--- Testing Pagination and Sorting (Exercise 6) ---");
            // Find IT employees, page 0, size 1, sorted by name descending
            Page<Employee> paginatedResult = employeeRepo.findByDepartmentId(
                    itDept.getId(), 
                    PageRequest.of(0, 1, Sort.by("name").descending())
            );
            System.out.println("IT Employees Page 0 (Size 1, Sort Name Desc):");
            paginatedResult.getContent().forEach(e -> System.out.println(" - " + e.getName()));

            // 8. Test Projections (Exercise 8)
            System.out.println("\n--- Testing Projections (Exercise 8) ---");
            List<EmployeeProjection> interfaceProjections = employeeRepo.findBySalaryGreaterThan(45000.0);
            System.out.println("Interface Projection (Salary > 45000):");
            interfaceProjections.forEach(p -> System.out.println(" - ID: " + p.getId() + ", Name: " + p.getName() + ", Email: " + p.getEmail()));

            List<EmployeeDto> classProjections = employeeRepo.findEmployeeDtosByDepartmentId(itDept.getId());
            System.out.println("Class-based DTO Projection (IT Dept):");
            classProjections.forEach(d -> System.out.println(" - Name: " + d.getName() + ", Department: " + d.getDepartmentName()));

            System.out.println("\n=== All EmployeeManagementSystem Demonstrations Completed Successfully ===");
        };
    }
}
