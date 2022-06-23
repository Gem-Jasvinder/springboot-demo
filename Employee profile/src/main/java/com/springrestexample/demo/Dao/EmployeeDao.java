package com.springrestexample.demo.Dao;

import com.springrestexample.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeDao extends JpaRepository<Employee, UUID> {
}
