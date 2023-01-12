package com.example.springbootdocker.services;

import com.example.springbootdocker.interfaces.CrudServiceInterface;
import com.example.springbootdocker.models.User;
import com.example.springbootdocker.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudServiceInterface<User> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user){
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user){
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> delete(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return userOptional;
    }

    @Override
    public Optional<User> getOne(Long id){
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
