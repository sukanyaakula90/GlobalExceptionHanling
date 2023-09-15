package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
