package com.empresa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.empresa.model.Employee;
import com.empresa.service.EmployeeService;

import jakarta.validation.ConstraintViolationException;

class EmployeeServiceTest {

	private EmployeeService service;
	
	@BeforeEach
	public void setup() {
		service = new EmployeeService(); 
	}
	
	@Test
	void testAddEmployeeNomeValido() {
		Employee employee = new Employee(1L, "João Silva");
		Employee salvo = service.salvar(employee);
		assertNotNull(salvo);
		assertEquals(1L,salvo.getId());
		assertEquals("João Silva",salvo.getNome());
	}
	
	@Test
	void testAddEmployeeNomeInvalidoNulo() {
		Employee employee = new Employee(1L, null, "joao.silva@email.com", "Desenvolvedor Back-end");
		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			service.salvar(employee);
		});
		assertTrue(exception.getMessage().contains("Nome não pode ser vazio"));
	}
	
	@Test
	void testAddEmployeeNomeInvalidoMuitoLongo() {
		String nomeLongo = "A".repeat(101);
		
		Employee employee = new Employee(1L, nomeLongo, "joao.silva@email.com", "Desenvolvedor Back-end");
		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			service.salvar(employee);
		});
		assertTrue(exception.getMessage().contains("Nome não pode ter mais do que 100 caracteres"));
	}
	
	
	@Test
	void testAddEmployeeComEmailValido() {
		Employee employee = new Employee(1L, "João Silva", "joao.silva@email.com");
		Employee salvo = service.salvar(employee);
		assertNotNull(salvo);
		assertEquals(1L,salvo.getId());
		assertEquals("joao.silva@email.com",salvo.getEmail());
	}
	
	@Test
	void testAddEmployeeComCargoValido() {
		Employee employee = new Employee(1L, "João Silva", "joao.silva@email.com", "Desenvolvedor Back-end");
		Employee salvo = service.salvar(employee);
		assertNotNull(salvo);
		assertEquals(1L,salvo.getId());
		assertEquals("Desenvolvedor Back-end",salvo.getDepartamento());
	}
	
	
}
