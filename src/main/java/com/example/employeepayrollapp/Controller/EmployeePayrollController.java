package com.example.employeepayrollapp.Controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Sachin", 500000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("employeeId") int employeeId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(2, new EmployeePayrollDTO("Dravid", 450000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(3, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Employee payroll data for:", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(3, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Employee payroll Data for: ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("employeeId") int employeeId) {
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "employeeId " + employeeId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}