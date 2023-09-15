package com.dakr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.ExceptionHandler.EmptyInputException;
import com.dakr.ExceptionHandler.NoSuchElementException;
import com.dakr.entity.Employee;
import com.dakr.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	@Autowired
	private EmployeeServiceInterface service; 
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)throws EmptyInputException{
		Employee employee = service.addEmployee(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		} 
	@GetMapping("/getAll")
	 public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> listofemployees =service.getAllEmployee();
		return new ResponseEntity<List<Employee>>(listofemployees,HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeId(@RequestParam Integer id) throws NoSuchElementException{
		Optional<Employee> getEmployee =service.getEmployeeId(id);
		return new ResponseEntity<Optional<Employee>>(getEmployee,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByEmployeeId(@RequestParam Integer id){
		 String  deletebyid =service.deleteEmployeeById(id);
		 return new ResponseEntity<>(deletebyid,HttpStatus.OK); 
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee ) throws NoSuchElementException{
		String emp = service.updateEmployee(id,employee);
		 return new ResponseEntity<>(emp,HttpStatus.ACCEPTED);
	}
}
