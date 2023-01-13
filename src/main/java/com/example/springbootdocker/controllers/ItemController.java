package com.example.springbootdocker.controllers;

import com.example.springbootdocker.dtos.ItemDto;
import com.example.springbootdocker.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("create")
    public ResponseEntity<Object> createItem(@RequestBody @Valid ItemDto itemDto){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.create(itemDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItem(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getOne(id));
    }
}
