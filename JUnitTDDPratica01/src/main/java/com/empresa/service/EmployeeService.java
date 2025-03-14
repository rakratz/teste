package com.empresa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.empresa.model.Employee;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class EmployeeService {
	
	private final Validator validator;

	private List<Employee> empregados = new ArrayList<>();
	
	// Inicializar o Validado no Construtor
	public EmployeeService() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
	}
	
	public Employee salvar(Employee employee) {
		Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
		empregados.add(employee);
		return employee;
	}
}
