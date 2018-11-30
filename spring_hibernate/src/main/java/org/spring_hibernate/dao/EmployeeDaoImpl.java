package org.spring_hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.spring_hibernate.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends Dao implements EmployeeDao {
    @Override
    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createQuery("delete from EMPLOYEE where ssn = :ssn");
        query.setString("ssn", ssn);
    }

    @Override
    public Employee findOneBySsn(String ssn) {
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }

    @Override
    public void updateEmployee(Employee employee) {
        getSession().update(employee);
    }
}
