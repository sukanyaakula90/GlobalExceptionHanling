package com.dakr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.ExceptionHandler.EmptyInputException;
import com.dakr.ExceptionHandler.NoSuchElementException;
import com.dakr.entity.Employee;
import com.dakr.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface {
@Autowired
private EmployeeRepository repo;

@Override
public Employee addEmployee(Employee emp) throws EmptyInputException {
	if(emp.getFirstName().isEmpty()||emp.getLastName().isEmpty() ){
		throw new EmptyInputException();
	}
	return repo.save(emp);
}

@Override
public List<Employee> getAllEmployee() {
	return repo.findAll(); 
}

@Override
public Optional<Employee> getEmployeeId(Integer id)throws NoSuchElementException {
	Optional<Employee> emp = repo.findById(id);
	if(!emp.isPresent()) {
		throw new NoSuchElementException();
	}
    return repo.findById(id);
}

@Override
public String deleteEmployeeById(Integer id) {
	String temp = " ";
	if(repo.findById(id).isPresent()) {
		repo.deleteById(id);
		 temp= "Employee Deleted Sucessfully......";
		 
	}else {
		 temp =id+"Not Present In DataBase and Please enter valid Id ";
	}
	return temp;
}

@Override
public String updateEmployee(Integer id, Employee employee) throws NoSuchElementException {
	Optional<Employee> emp = repo.findById(id);
	 
	if(!emp.isPresent()) {
		throw  new NoSuchElementException();
		}
	
		Employee employee1 =emp.get();
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setEmail(employee.getEmail());
		employee1.setEmail(employee.getEmail());
		employee1.setAddress(employee.getAddress());
		employee1.setPhNo(employee.getPhNo());
		
	 
			repo.save(employee1);
			return "Data Updated Sucessfully";
	}

}
