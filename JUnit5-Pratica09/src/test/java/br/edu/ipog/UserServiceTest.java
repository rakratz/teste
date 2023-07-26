package br.edu.ipog;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.edu.ipog.model.User;
import br.edu.ipog.repository.UserRepository;
import br.edu.ipog.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Criação do mock do UserRepository
        UserRepository userRepository = mock(UserRepository.class);

        // Definindo o comportamento do mock quando o método findById é chamado com o argumento 1
        User user = new User(1, "John Doe");
        when(userRepository.findById(1)).thenReturn(user);

        // Criando o UserService e passando o mock do UserRepository
        UserService userService = new UserService(userRepository);

        // Chamando o método getUserById com o argumento 1
        User result = userService.getUserById(1);

        // Verificando se o resultado é o mesmo do objeto user criado anteriormente
        assertEquals(user, result);

        // Verificando se o método findById foi chamado exatamente uma vez com o argumento 1
        verify(userRepository, times(1)).findById(1);
    }
    
    @ParameterizedTest
    @CsvSource({ "1, John Doe", "2, Jane Smith", "3, Bob Johnson" })
    public void testGetUserById(int id, String name) {
        // Criação do mock do UserRepository
        UserRepository userRepository = mock(UserRepository.class);

        // Definindo o comportamento do mock quando o método findById é chamado com o argumento id
        User user = new User(id, name);
        when(userRepository.findById(id)).thenReturn(user);

        // Criando o UserService e passando o mock do UserRepository
        UserService userService = new UserService(userRepository);

        // Chamando o método getUserById com o argumento id
        User result = userService.getUserById(id);

        // Verificando se o resultado é o mesmo do objeto user criado anteriormente
        assertEquals(user, result);

        // Verificando se o método findById foi chamado exatamente uma vez com o argumento id
        verify(userRepository, times(1)).findById(id);
    }
}