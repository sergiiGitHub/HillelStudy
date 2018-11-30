package org.spring_hibernate.service;

import org.spring_hibernate.dao.EmployeeDao;
import org.spring_hibernate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        employeeDao.deleteEmployeeBySsn(ssn);
    }

    @Override
    public Employee findOneBySsn(String ssn) {
        return employeeDao.findOneBySsn(ssn);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }
}
