package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testEmployee {

    private Departament departament;
    private Employee employee;
    
    @BeforeEach
    public void setUp() {
        departament = new Departament("IT");
        employee = new Employee("João", "Silva", "joao@gmail.com");
        departament.addEmployee(employee);
    }
	
	@Test
	public void testAddEmployee() {
		assertEquals(1, departament.getEmployees().size());
		assertEquals(employee, departament.getEmployees().get(0));
	}
	
	@Test
    public void testEditEmployeeData() {
        
        // Atualiza os dados do funcionário
        employee.setEmail("joao@newemail.com");
        employee.setJobTitle("Analista de Sistemas");
        
        // Verifica se os dados do funcionário foram atualizados corretamente
        assertEquals("Analista de Sistemas", employee.getJobTitle());
        assertEquals("joao@newemail.com", employee.getEmail());
    }
	
	   @Test
	    public void testListEmployees() {
	        // Verifica se a lista de funcionários contém o funcionário adicionado
	        List<Employee> employees = departament.getEmployees();
	        assertTrue(employees.contains(employee));
	    }
	   @Test
	    public void testGettersAndSetters() {
	        // Teste para o getter e setter de FirstName
	        employee.setFirstName("Maria");
	        assertEquals("Maria", employee.getFirstName());        
	        // Teste para o getter e setter de LastName
	        employee.setLastName("Santos");
	        assertEquals("Santos", employee.getLastName());
	        // Teste para o getter e setter de Email
	        employee.setEmail("maria@gmail.com");
	        assertEquals("maria@gmail.com", employee.getEmail());
	        // Teste para o getter e setter de JobTitle
	        employee.setJobTitle("Desenvolvedor");
	        assertEquals("Desenvolvedor", employee.getJobTitle());
	    }	   
	   @Test
	    public void testDeleteEmployee() {       
	        // Exclui o funcionário
	        departament.removeEmployee(employee);
	        
	        // Verifica se o funcionário foi removido com sucesso
	        List<Employee> employeesAfterDeletion = departament.getEmployees();
	        assertFalse(employeesAfterDeletion.contains(employee));
	    }
}







