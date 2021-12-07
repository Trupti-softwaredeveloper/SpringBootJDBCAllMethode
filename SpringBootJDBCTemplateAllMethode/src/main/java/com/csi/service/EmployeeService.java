package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void signUp(Employee employee);

    public void saveAllData(List<Employee> employees);

    public List<Employee>getAllData();

    public boolean signIn(String empEmailId,String empPassword);

    public Employee getDataById(int empId);

    public Employee getDataByName(String empName);

    public Employee getDataByContactNumber(long empContactNumber);

    public Employee getDataByEmailId(String empEmailId);
}
