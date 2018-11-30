package org.spring_hibernate.service;

import org.spring_hibernate.model.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    //Social security number
    void deleteEmployeeBySsn(String ssn);

    Employee findOneBySsn(String ssn);

    void updateEmployee(Employee employee);
}
