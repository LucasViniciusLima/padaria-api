package com.example.springbootdocker.controllers;

import com.example.springbootdocker.dtos.UserDto;
import com.example.springbootdocker.models.User;
import com.example.springbootdocker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> addNewUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.create(userDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value="id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value="id") Long id, @RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.update(id, user));
    }

    @GetMapping(path="/all")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAll());
    }
}
