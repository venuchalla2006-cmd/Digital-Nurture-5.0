package com.cognizant.springlearn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Department {
    @NotNull(message = "Department ID should not be null")
    private Integer id;

    @NotNull(message = "Department name should not be null")
    @NotBlank(message = "Department name should not be blank")
    @Size(min = 1, max = 30, message = "Department name should be between 1 and 30 characters")
    private String name;
}
