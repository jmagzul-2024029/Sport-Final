package com.jorgemagzul.sportfinal.repository;

import com.jorgemagzul.sportfinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //anotacion
public interface UserRepository extends JpaRepository<User, Integer>{ //se extiende de JpaRepository

    //verificar si existe un usuario con el email
    boolean existsByEmail(String email);

    //verificar si existe alguien llamado igual(nombre y apellido)
    boolean existsByFirstNameAndLastNameAndIdNot(String firstName, String lastName, Integer id);


}
