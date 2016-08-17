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
	
	private static List<Employee> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<Employee> findAllUsers() {
		return users;
	}
	
	public Employee findById(long id) {
		for(Employee user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public Employee findByName(String name) {
		for(Employee user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(Employee user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(Employee user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<Employee> iterator = users.iterator(); iterator.hasNext(); ) {
		    Employee user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(Employee user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<Employee> populateDummyUsers(){
		List<Employee> users = new ArrayList<Employee>();
		users.add(new Employee(counter.incrementAndGet(),"Beckett",38, 150000,"Male"));
		users.add(new Employee(counter.incrementAndGet(),"Delaney",23, 50000, "Gemale"));
		users.add(new Employee(counter.incrementAndGet(),"Quinlynn",25, 110000, "Gemale"));
		users.add(new Employee(counter.incrementAndGet(),"Magnus",24, 140000, "Male"));
		return users;
	}
	
}
