package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.employee.projection.EmployeeProjection;
import com.employee.projection.EmployeeDto;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // 1. Derived Query Method (Exercise 3)
    List<Employee> findByNameContaining(String namePart);

    List<Employee> findByDepartmentId(Long deptId);

    // 2. Custom JPQL Query via @Query (Exercise 5)
    @Query("SELECT e FROM Employee e WHERE e.salary >= :minSalary")
    List<Employee> findEmployeesWithHighSalary(@Param("minSalary") Double minSalary);

    // 3. Native Query via @Query (Exercise 5)
    @Query(value = "SELECT * FROM employees WHERE email LIKE %:domain", nativeQuery = true)
    List<Employee> findEmployeesByEmailDomain(@Param("domain") String domain);

    // 4. Executing Named Queries (Exercise 5)
    Employee findByEmailNamed(@Param("email") String email);
    
    List<Employee> findByDepartmentNameNamed(@Param("deptName") String deptName);

    // 5. Pagination and Sorting (Exercise 6)
    Page<Employee> findByDepartmentId(Long deptId, Pageable pageable);

    // 6. Projections (Exercise 8)
    // Interface-based projection
    List<EmployeeProjection> findBySalaryGreaterThan(Double minSalary);

    // Class-based projection (DTO)
    @Query("SELECT new com.employee.projection.EmployeeDto(e.id, e.name, e.email, e.department.name) " +
           "FROM Employee e WHERE e.department.id = :deptId")
    List<EmployeeDto> findEmployeeDtosByDepartmentId(@Param("deptId") Long deptId);
}
