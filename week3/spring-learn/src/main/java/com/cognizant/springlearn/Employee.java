package com.cognizant.springlearn;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class Employee {
    @NotNull(message = "Employee ID should not be null")
    private Integer id;

    @NotNull(message = "Employee name should not be null")
    @NotBlank(message = "Employee name should not be blank")
    @Size(min = 1, max = 30, message = "Employee name should be between 1 and 30 characters")
    private String name;

    @NotNull(message = "Salary should not be null")
    @Min(value = 0, message = "Salary should be zero or above")
    private Double salary;

    @NotNull(message = "Permanent status should not be null")
    private Boolean permanent;

    @NotNull(message = "Date of birth should not be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dateOfBirth;

    @Valid
    @NotNull(message = "Department should not be null")
    private Department department;

    @Valid
    @NotNull(message = "Skills list should not be null")
    private List<Skill> skills;
}
