package com.example.employeepayrollapp.Service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int employeeId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int employeeId);

    List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String departments);

    List<EmployeePayrollData> getEmployeeByName(String name);

    List<EmployeePayrollData> getEmployeeByGender(String gender);
}