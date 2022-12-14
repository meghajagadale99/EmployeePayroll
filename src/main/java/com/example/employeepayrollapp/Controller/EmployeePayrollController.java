package com.example.employeepayrollapp.Controller;

import com.example.employeepayrollapp.Service.IEmployeePayrollService;
import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * Receive various HTTP request from clint
 *
 * @author Megha Jagadale
 * @version 0.0.1
 * @since 14/8/2022
 */
@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable(value = "employeeId") int employeeId) {
        EmployeePayrollData payrollData = null;
        payrollData = employeePayrollService.getEmployeePayrollDataById(employeeId);
        ResponseDTO respDTO = new ResponseDTO("Get Call Success for id:", payrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        log.debug("Employee DTO" + employeePayrollDTO.toString());
        EmployeePayrollData payrollData = null;
        payrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee payroll data for:", payrollData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable(value = "employeeId") int employeeId,
                                                                 @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData payrollData = null;
        payrollData = employeePayrollService.updateEmployeePayrollData(employeeId, employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data for: ", payrollData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable(value = "employeeId") int employeeId) {
        employeePayrollService.deleteEmployeePayrollData(employeeId);
        ResponseDTO respDTO = new ResponseDTO("Delete Call Success for id: ", "employeeId " + employeeId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/departments/{departments}")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable String departments) {

        List<EmployeePayrollData> employeeList = null;
        employeeList = employeePayrollService.getEmployeesPayrollDataByDepartment(departments);
        ResponseDTO response = new ResponseDTO("Get Call for Department Successful", employeeList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public ResponseEntity<ResponseDTO> getEmployeeByName(@PathVariable String name) {
        List<EmployeePayrollData> employeeList = employeePayrollService.getEmployeeByName(name);
        ResponseDTO responseDTO = new ResponseDTO("The Employee of name :" + name, employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/getEmployeeByGender")
    public ResponseEntity<ResponseDTO> getEmployeeByGender(@Valid @RequestParam String gender) {
        List<EmployeePayrollData> employeeList = employeePayrollService.getEmployeeByGender(gender);
        ResponseDTO responseDTO = new ResponseDTO("The Employees who are :" + gender, employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }

}