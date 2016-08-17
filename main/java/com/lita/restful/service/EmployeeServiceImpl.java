package com.lita.restful.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lita.restful.model.Employee;

@Service("userService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Employee> employees;
	
	static{
		employees= populateDummyUsers();
	}

	public List<Employee> findAllEmployees() {
		return employees;
	}
	
	public Employee findById(long id) {
		for(Employee employee : employees){
			if(employee.getId() == id){
				return employee;
			}
		}
		return null;
	}
	
	public Employee findByName(String name) {
		for(Employee employee : employees){
			if(employee.getName().equalsIgnoreCase(name)){
				return employee;
			}
		}
		return null;
	}
	
	public void saveEmployee(Employee employee) {
		employee.setId(counter.incrementAndGet());
		employees.add(employee);
	}

	public void updateEmployee(Employee employee) {
		int index = employees.indexOf(employee);
		employees.set(index, employee);
	}

	public void deleteEmployeeById(long id) {
		
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
		    Employee employee = iterator.next();
		    if (employee.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isEmployeeExist(Employee employee) {
		return findByName(employee.getName())!=null;
	}
	
	public void deleteAllEmployees(){
		employees.clear();
	}

	private static List<Employee> populateDummyUsers(){
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(counter.incrementAndGet(),"Beckett",38, 150000,"Male"));
		employees.add(new Employee(counter.incrementAndGet(),"Delaney",23, 50000, "Gemale"));
		employees.add(new Employee(counter.incrementAndGet(),"Quinlynn",25, 110000, "Gemale"));
		employees.add(new Employee(counter.incrementAndGet(),"Magnus",24, 140000, "Male"));
		return employees;
	}
	
}
