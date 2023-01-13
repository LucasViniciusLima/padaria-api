package com.example.springbootdocker.services;

import com.example.springbootdocker.dtos.UserDto;
import com.example.springbootdocker.interfaces.CrudServiceInterface;
import com.example.springbootdocker.models.User;
import com.example.springbootdocker.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudServiceInterface<User> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        var userModel = new User();
        BeanUtils.copyProperties(user, userModel);
        return userRepository.save(userModel);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> delete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return userOptional;
    }

    @Override
    public Optional<User> getOne(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userOptional;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
