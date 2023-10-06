package br.edu.ipog.JUnitTestBancoH2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.edu.ipog.JUnitTestBancoH2.model.User;
import br.edu.ipog.JUnitTestBancoH2.repositories.UserRepository;

class UserTest {
	
	
	@Test
	void testUser() {
		User user = new User();
		Long result = user.getId(); 
		assertEquals(1, 1);
	}

}
