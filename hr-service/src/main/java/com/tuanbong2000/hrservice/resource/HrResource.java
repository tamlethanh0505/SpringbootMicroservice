package com.tuanbong2000.hrservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuanbong2000.hrservice.models.Employee;
import com.tuanbong2000.hrservice.models.EmployeesList;

@RestController
@RequestMapping("/hr")
public class HrResource {
	List<Employee> employees = Arrays.asList(
			new Employee("Em1", "Quang", "HNO"),
			new Employee("Em2", "Na","Psychology")
			);
	@RequestMapping("/employees")
	public EmployeesList getEmployees() {
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployeesList(employees);
		return employeesList;
		
	}
	
	@RequestMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id) {
		
		Employee e = employees.stream()
				.filter(employee -> id.equals(employee.getId()))
				.findAny()
				.orElse(null);				
		return e;
	}
}
