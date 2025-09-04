package com.empresa.model;

import java.util.List;
import java.util.ArrayList;

public class Departament {
	private String name;
	private List<Employee> employees;
	
	
	public Departament(String name) {
		this.name = name;
		this.employees = new ArrayList<>();
	}


	public void addEmployee(Employee employee) {
		this.employees.add(employee);
		
	}
	
	
}
