package com.met.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.met.dao.EmployeeDAO;
import com.met.model.Employee;

//@Component
@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void save(Employee employee) {
	
		
		
//		if(employee.getMobile()) {
//			throw new RuntimeException("Mobile Number cannot be > 10");
//		}
		
		if(!employee.getPassword().equals(employee.getConfirmPassword())) {
			throw new RuntimeException("Password and Confirm Password Need To Be Same");
		}
		
		System.out.println("EmployeeService :: save");
		employeeDAO.save(employee);
		
		
		System.out.println("Employee DAO class: " + employeeDAO.getClass());
		
	}
	
	
	
	public  Collection<Employee> getAllEmployees(){
		
		return employeeDAO.getAllEmployees();
		
	}
	
	
}
