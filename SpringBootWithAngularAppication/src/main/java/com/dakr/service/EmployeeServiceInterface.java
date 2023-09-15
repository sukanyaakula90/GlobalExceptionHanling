package com.dakr.service;

import java.util.List;
import java.util.Optional;

import com.dakr.ExceptionHandler.EmptyInputException;
import com.dakr.ExceptionHandler.NoSuchElementException;
import com.dakr.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee emp) throws EmptyInputException;

	public List<Employee> getAllEmployee();

	public Optional<Employee> getEmployeeId(Integer id) throws NoSuchElementException;

	public String deleteEmployeeById(Integer id);

	
	public String updateEmployee(Integer id, Employee employee) throws NoSuchElementException;

}
