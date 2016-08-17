package com.lita.restful.service;

import java.util.List;

import com.lita.restful.model.Employee;

public interface EmployeeService {
	Employee findById(long id);
	
	Employee findByName(String name);
	
	void saveUser(Employee user);
	
	void updateUser(Employee user);
	
	void deleteUserById(long id);

	List<Employee> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(Employee user);
}
