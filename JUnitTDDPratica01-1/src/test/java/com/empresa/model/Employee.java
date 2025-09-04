package com.empresa.model;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String email;
	private Double salary;
	private Position position;
	private String jobTitle;
	
	
	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Employee(String nome, String email, Double salario, Position posicao) {
		
		String n = nome.trim().replaceAll("\\s+", " ");
        int idx = n.lastIndexOf(' ');
        if (idx < 0) {
            this.firstName = n;
            this.lastName  = "";
        } else {
            this.firstName = n.substring(0, idx);
            this.lastName  = n.substring(idx + 1);
        }
        
		this.email = email;
		this.salary = salario;
		this.position = posicao;
	}


	public String getName() {
		return firstName + " " + lastName;
	}
	
	
	
	public Double getSalary() {
		return salary;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	
	
	
}
