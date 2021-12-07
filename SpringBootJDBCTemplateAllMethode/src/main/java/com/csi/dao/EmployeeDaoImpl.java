package com.csi.dao;

import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String INSERT_SQl="insert into employee(empid ,empname ,empsalary ,empcontactnumber ,empdob ,empuid ,empemailid ,emppassword )values(?,?,?,?,?,?,?,?)";

    public String SELECT_ALL_SQL="select * from employee";

    public String SIGNIN_SQL="select * from employee where empemailid=? and emppassword=?";

    public String SELECT_DATA_BY_ID="select * from employee where empid=?";

    public String SELECT_DATA_BY_NAME="select * from employee where empname=?";

    public String SELECT_DATA_BY_CONTACT_NUMBER="select * from employee where empcontactnumber=?";

    public String SELECT_DATA_BY_EMAILID="select * from employee where empemailid=?";

    private Employee employee(ResultSet resultSet,int numRow) throws SQLException {
        return Employee.builder().empId(resultSet.getInt(1)).empName(resultSet.getString(2)).empSalary(resultSet.getDouble(3)).empContactNumber(resultSet.getLong(4)).empDOB(resultSet.getDate(5)).empUID(resultSet.getLong(6)).empEmailId(resultSet.getString(7)).empPassword(resultSet.getString(8)).build();

    }



    @Override
    public void signUp(Employee employee) {

     jdbcTemplate.update(INSERT_SQl,employee.getEmpId(),employee.getEmpName(),employee.getEmpSalary(),employee.getEmpContactNumber(),employee.getEmpDOB(),employee.getEmpUID(),employee.getEmpEmailId(),employee.getEmpPassword());

    }

    @Override
    public void saveAllData(List<Employee> employees) {
     for(Employee employee:employees)
     {
         jdbcTemplate.update(INSERT_SQl,employee.getEmpId(),employee.getEmpName(),employee.getEmpSalary(),employee.getEmpContactNumber(),employee.getEmpDOB(),employee.getEmpUID(),employee.getEmpEmailId(),employee.getEmpPassword());
     }
    }

    @Override
    public List<Employee> getAllData() {
        return jdbcTemplate.query(SELECT_ALL_SQL,this::employee);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag=false;
        List<Employee>employeeList=jdbcTemplate.query(SELECT_ALL_SQL,this::employee);
         for (Employee employee:employeeList)
         {
             if(employee.getEmpEmailId().equals(empEmailId)&&employee.getEmpPassword().equals(empPassword));
             {
                 flag=true;
             }
         }
        return flag;
    }

    @Override
    public Employee getDataById(int empId) {
        return jdbcTemplate.query(SELECT_DATA_BY_ID,this::employee,empId).get(0);
    }

    @Override
    public Employee getDataByName(String empName) {
          return jdbcTemplate.query(SELECT_DATA_BY_NAME,this::employee,empName).get(0);
    }

    @Override
    public Employee getDataByContactNumber(long empContactNumber) {
        return jdbcTemplate.query(SELECT_DATA_BY_CONTACT_NUMBER,this::employee,empContactNumber).get(0);
    }

    @Override
    public Employee getDataByEmailId(String empEmailId) {
         return jdbcTemplate.query(SELECT_DATA_BY_EMAILID,this::employee,empEmailId).get(0);
    }
}
