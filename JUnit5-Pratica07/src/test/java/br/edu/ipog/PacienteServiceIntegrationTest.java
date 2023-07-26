package br.edu.ipog;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.edu.ipog.model.Paciente;
import br.edu.ipog.service.PacienteService;

public class PacienteServiceIntegrationTest {

    private PacienteService pacienteService;
    
	private static int testContador = 0; 
	private static int passContador = 0; 
    
	@BeforeAll
	public static void testInicio() {
		System.out.println("********************************");
		System.out.println("*      Testes Iniciados        *");
		System.out.println("********************************");
	}

    @BeforeEach
    public void setUp() {
        pacienteService = new PacienteService();
        System.out.print(++testContador+"º Teste Iniciado...");
    }

    @AfterEach
    public void tearDown() {
        pacienteService = null;
        System.out.println("Pass");
    }
    
	@AfterAll
	public static void testRelatorio() {
	    System.out.println("********************************");
	    System.out.println("Total de Testes = " + testContador);
	    System.out.println("Sucessos = " + passContador);
	    System.out.println("Falhas = " + (testContador  - passContador));
	    float porcentagem = ((float) passContador / testContador) * 100;
	    System.out.println("Porcentagem = " + porcentagem + "%");
	    System.out.println("********************************");
	}

    @Test
    @Order(1)
    public void testCRUDPaciente() {
        // Adicionar paciente
        Paciente paciente1 = new Paciente(1, "João", 25);
        pacienteService.adicionarPaciente(paciente1);

        // Buscar paciente por id
        Paciente pacienteBuscado = pacienteService.buscarPacientePorId(1);
        Assertions.assertEquals(paciente1, pacienteBuscado);

        // Listar pacientes
        List<Paciente> pacientes = pacienteService.listarPacientes();
        Assertions.assertEquals(1, pacientes.size());

        // Atualizar paciente
        paciente1.setNome("José");
        paciente1.setIdade(30);
        pacienteService.atualizarPaciente(paciente1);
        Paciente pacienteAtualizado = pacienteService.buscarPacientePorId(1);
        Assertions.assertEquals("José", pacienteAtualizado.getNome());
        Assertions.assertEquals(30, pacienteAtualizado.getIdade());

        // Excluir paciente
        pacienteService.excluirPaciente(1);
        Paciente pacienteExcluido = pacienteService.buscarPacientePorId(1);
        Assertions.assertNull(pacienteExcluido);
        ++passContador;
    }
    
    @ParameterizedTest
    @Order(2)
    @CsvSource({
            "1, João, 25, José, 30",
            "2, Maria, 35, Ana, 40",
            "3, Pedro, 40, Carlos, 50"
    })
    public void testAtualizarPaciente(int id, String nomeAntigo, int idadeAntiga, String nomeNovo, int idadeNova) {
        // Adicionar paciente
        Paciente paciente = new Paciente(id, nomeAntigo, idadeAntiga);
        pacienteService.adicionarPaciente(paciente);

        // Atualizar paciente
        paciente.setNome(nomeNovo);
        paciente.setIdade(idadeNova);
        pacienteService.atualizarPaciente(paciente);

        // Buscar paciente atualizado
        Paciente pacienteAtualizado = pacienteService.buscarPacientePorId(id);
        assertEquals(nomeNovo, pacienteAtualizado.getNome());
        assertEquals(idadeNova, pacienteAtualizado.getIdade());
        
        ++passContador;
    }
}