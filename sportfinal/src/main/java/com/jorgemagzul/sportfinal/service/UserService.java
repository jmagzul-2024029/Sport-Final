package com.jorgemagzul.sportfinal.service;

import com.jorgemagzul.sportfinal.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User saveUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id); //se crea un metodo


}
