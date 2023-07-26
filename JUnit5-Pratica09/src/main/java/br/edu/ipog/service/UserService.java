package br.edu.ipog.service;

import br.edu.ipog.model.User;
import br.edu.ipog.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId);
    }
}