package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FuncionarioTest {

	@Test
	void testeConbstrutorFuncionario() {
		Funcionario funcionario1 = new Funcionario();
		Funcionario funcionario2 = new Funcionario("João", 30, 2500.0);
		
		assertNull(funcionario1.getNome());
		assertEquals(0, funcionario1.getIdade());
		assertEquals(0.0, funcionario1.getSalario());

		
		assertEquals("João", funcionario2.getNome());
		assertEquals(30, funcionario2.getIdade());
		assertEquals(2500.0, funcionario2.getSalario());
	}

}
