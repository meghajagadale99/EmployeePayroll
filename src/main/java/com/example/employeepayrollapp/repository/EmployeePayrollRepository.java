package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
    @Query(value = "select * from employeepayrollapp,employee_department where employee_id=id and departments = :departments", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String departments);
    @Query(value = "select * from employeepayrollapp,employee_department where employee_id = employee_department.id and name = :name",nativeQuery = true)
    List<EmployeePayrollData> getEmployeeByName(String name);
    @Query(value = "select * from employeepayrollapp,employee_department where employee_id = employee_department.id and gender = :gender",nativeQuery = true)
    List<EmployeePayrollData> getEmployeeByGender(String gender);


}