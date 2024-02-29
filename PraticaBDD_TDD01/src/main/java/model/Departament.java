package model;

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
		employees.add(employee);
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
		
	}
}
