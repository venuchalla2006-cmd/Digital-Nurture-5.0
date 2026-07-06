package com.employee.model;

import javax.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByEmailNamed",
        query = "SELECT e FROM Employee e WHERE e.email = :email"
    ),
    @NamedQuery(
        name = "Employee.findByDepartmentNameNamed",
        query = "SELECT e FROM Employee e WHERE e.department.name = :deptName"
    )
})
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private Double salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;
}
