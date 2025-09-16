package com.jorgemagzul.sportfinal.service;

import com.jorgemagzul.sportfinal.model.User;
import com.jorgemagzul.sportfinal.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service //anotacion
public class UserServiceImpl implements UserService{ //implementar servicios de User
    //                              nombre de como se implementa
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) { //constructor
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        //validar la duplicación del correo
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este correo ya existe, no pueden haber dos iguales.");
        }

        if (userRepository.existsByFirstNameAndLastNameAndIdNot(user.getFirstName(), user.getLastName(), user.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe un usuario con esos datos, no se puede ingresar uno igual.");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        User existinUser = userRepository.findById(id).orElse(null);
        if (existinUser !=  null) {//si es diferente a null

            //validar si el nuevo correo es diferente alactual cuamdo se actualiza
            if (!existinUser.getEmail().equals(user.getEmail()) && userRepository.existsByEmail(user.getEmail())){
                throw new IllegalArgumentException("El correo ya está siendo utilizado por otro usuario");
            }
            //validar si el nombre y apellido están duplicados
            if ((!existinUser.getFirstName().equals(user.getFirstName()) || !existinUser.getLastName().equals(user.getLastName()))
                    && userRepository.existsByFirstNameAndLastNameAndIdNot(user.getFirstName(), user.getLastName(), user.getId())){
                throw new IllegalArgumentException("Estos datos ya están siendo utilizados y no se pueden repetir");
            }
            //actualizar campos
            existinUser.setFirstName(user.getFirstName());//setear
            existinUser.setLastName(user.getLastName());
            existinUser.setEmail(user.getEmail());
            return userRepository.save(existinUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
