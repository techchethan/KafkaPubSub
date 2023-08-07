package com.example.kafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class Employee {
    @Setter
    @Getter
    @JsonProperty("Id")
    int id;

    @JsonProperty("employeeName")
    String name;
    @JsonProperty("employeeId")
    String empId;
    @JsonProperty("employeeSalary")
    String salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empId='" + empId + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
