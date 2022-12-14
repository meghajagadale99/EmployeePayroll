package com.example.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;
/**
 * Receive data object from clint
 *
 * @author Megha Jagadale
 * @version 0.0.1
 * @since 14/8/2022
 */
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    @NotEmpty(message = "Employee Name can't be null")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = " Gender  needs to be male or female")
    public String gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "StartDate should not be empty")
    @PastOrPresent(message = "startDate should be past or toDays")
    public LocalDate startDate;

    @NotBlank(message = "Note can not be empty")
    public String note;

    @NotBlank(message = "profilePic can not be empty")
    public String profilePic;

    @NotNull(message = "department should not be empty")
    public List<String> departments;
}
