package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int empId;

    private String empName;

    private double empSalary;

    private long empContactNumber;

   @JsonFormat(pattern = "dd-MM-yyyy",timezone = "Assia/Kolkata")
    private Date empDOB;

   private long empUID;

   private String empEmailId;

   private String empPassword;



}
