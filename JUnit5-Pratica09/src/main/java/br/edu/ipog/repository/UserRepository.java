package br.edu.ipog.repository;

import br.edu.ipog.model.User;

public interface UserRepository {
    User findById(int userId);
}