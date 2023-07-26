package br.edu.ipog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ipog.exceptions.ValidationException;

public class testUsuario {

	@Test
	public void testCriarUsuarioValido() {
		Usuario usuario = new Usuario(1L,"Nome do Usuário","nome@email.com","123456");
        Assertions.assertAll("Usuario",
                () -> assertEquals(1L, usuario.getId()),
                () -> assertEquals("Nome do Usuário", usuario.getNome()),
                () -> assertEquals("nome@email.com", usuario.getEmail()),
                () -> assertEquals("123456", usuario.getSenha())
        );
        // assertEquals(1L, usuario.getId());
        // assertEquals("Nome do Usuário", usuario.getNome());
        // assertEquals("nome@email.com", usuario.getEmail());
        // assertEquals("123456", usuario.getSenha());
	}
	
    @Test
    public void testNaoPermitirUsuarioSemNome() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
            Usuario usuario = new Usuario(1L, null, "nome@email.com", "123456");  });
        assertEquals("Nome é Obrigatório", ex.getMessage());
	}
    
    @Test
    public void testNaoPermitirUsuarioSemEmail() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
            Usuario usuario = new Usuario(1L, "Nome do Usuário", null, "123456");  });
        assertEquals("E-mail é Obrigatório", ex.getMessage());
	}
    
    @Test
    public void testNaoPermitirUsuarioSemSenha() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
            Usuario usuario = new Usuario(1L, "Nome do Usuário", "nome@email.com", null);  });
        assertEquals("Senha é Obrigatória", ex.getMessage());
	}
}