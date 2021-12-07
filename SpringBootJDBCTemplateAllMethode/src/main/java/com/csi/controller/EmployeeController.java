package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1")
public class EmployeeController {
    @Autowired

    EmployeeService employeeService;

    @PostMapping("/signup")
    public String signUp(@RequestBody Employee employee)
    {
        employeeService.signUp(employee);
        return "Sign up Successfiully";
    }

    @PostMapping("/savealldata")
    public String saveAllData(@RequestBody List<Employee>employees)
    {
        employeeService.saveAllData(employees);
        return "Save all data successfully";
    }

    @GetMapping("/getalldata")
    public List<Employee>getAllData()
    {
       return employeeService.getAllData();
    }


    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public boolean signIn(@PathVariable String empEmailId,@PathVariable String empPassword)
    {
        return employeeService.signIn(empEmailId,empPassword);
    }

    @GetMapping("/getdatabyid/{empId}")
    public Employee getDataById(@PathVariable int empId )
    {
        return employeeService.getDataById(empId);
    }

    @GetMapping("/getdatabyname/{empName}")
    public Employee getDataByName(@PathVariable String empName )
    {
        return employeeService.getDataByName(empName);
    }

    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public Employee getDataByContactNumber(@PathVariable long empContactNumber )
    {
        return employeeService.getDataByContactNumber(empContactNumber);
    }

    @GetMapping("/getdatabyemailid/{empEmailId}")
    public Employee getDataByEmailId(@PathVariable String empEmailId )
    {
        return employeeService.getDataByEmailId(empEmailId);
    }

    @GetMapping("/getdatabyemppassword/{empPassword}")
    public Employee getDataByPassword(@PathVariable String empPassword )
    {
        return employeeService.getDataByPassword(empPassword);
    }
}
