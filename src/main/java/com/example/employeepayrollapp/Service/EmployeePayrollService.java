package com.example.employeepayrollapp.Service;

import com.example.employeepayrollapp.Exception.EmployeePayrollException;
import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Layer contains business logic,
 * also implements all the method in controller layer
 *
 * @author Megha Jagadale
 * @version 0.0.1
 * @since 14/8/2022
 */
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
        return employeePayrollRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeePayrollException(("Employee with EmployeeId" + employeeId
                        + " Doesn't Exists...!")));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Employee Data: " +empData.toString() );
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
        empData.updateEmployeePayollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int employeeId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
        employeePayrollRepository.delete(empData);
    }

    @Override
    public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String departments) {
        return employeePayrollRepository.findEmployeesByDepartment(departments);
    }
}
