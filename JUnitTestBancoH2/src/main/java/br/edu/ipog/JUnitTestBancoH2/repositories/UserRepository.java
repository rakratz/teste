package br.edu.ipog.JUnitTestBancoH2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ipog.JUnitTestBancoH2.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
