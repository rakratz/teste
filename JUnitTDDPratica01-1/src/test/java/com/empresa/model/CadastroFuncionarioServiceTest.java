package com.empresa.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CadastroFuncionarioServiceTest {

	private Departament departament;
	private Employee employee;
	
	@BeforeEach
	public void setup() {
		departament = new Departament("IT");
		employee = new Employee("João", "Silva", "joao@gmail.com");
		departament.addEmployee(employee);
	}
	
	@Test
	void testEditEmployeeData() {
		 // Atualiza os dados do funcionário
        employee.setEmail("joao@newemail.com");
        employee.setJobTitle("Analista de Sistemas");
        
        // Verifica se os dados do funcionário foram atualizados corretamente
        assertEquals("Analista de Sistemas", employee.getJobTitle());
        assertEquals("joao@newemail.com", employee.getEmail());
	}
	
	@Test 
	void testAddEmployeeWithBalidName() {
		String nome = "Ricardo Kratz";
		String email = "ricardo@email.com";
		Double salario = 3000.0;
		Position posicao = Position.DESENVOLVEDOR;
		
		Employee employee = new Employee(nome, email, salario, posicao);
		
		assertEquals(nome, employee.getName());
        assertEquals(email, employee.getEmail());
        assertEquals(salario, employee.getSalary());
        assertEquals(posicao, employee.getPosition());
		
	}

}
