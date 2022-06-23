package com.springrestexample.demo.Dao;

import com.springrestexample.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//public class EmployeeDaoImpl  {
//
//    @Autowired
//    EmployeeDao employeeDao;
//
//
//    public boolean saveData(Employee employee)
//    {
//        employee = commonSetterCourseUser(employee, true);
//        employeeDao.save(employee);
//        return true;
//    }
//
//    private Employee commonSetterCourseUser(Employee employee, boolean isNew) {
//        employee.setCreateDate(isNew ? (new Date()) : employee.getCreateDate());
//        employee.setUpdateDate((new Date()));
//        employee.setRecord(1);
//        return employee;
//    }
//
//}

public class EmployeeDaoImpl {

    @Lazy
    @Autowired
    public EmployeeDao employeeDao;
    public boolean saveData(Employee employee){

        employee = commonSetterCourseUser(employee,true);
        employeeDao.save(employee);
        return true;
    }

    public Employee commonSetterCourseUser(Employee employee, boolean isNew) {
        employee.setCreateDate(isNew ? (new Date()) :employee.getCreateDate() );
        employee.setUpdateDate((new Date()));
        employee.setRecord(1);
        return employee;
    }

}