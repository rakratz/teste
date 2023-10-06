package br.edu.ipog.JUnitTestBancoH2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ipog.JUnitTestBancoH2.repositories.UserRepository;

import br.edu.ipog.JUnitTestBancoH2.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAll(){
		List<User> result = repository.findAll();
		return result;
	}
	
}
