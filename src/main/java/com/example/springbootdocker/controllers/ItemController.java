package com.example.springbootdocker.controllers;

import com.example.springbootdocker.dtos.ItemDto;
import com.example.springbootdocker.models.Item;
import com.example.springbootdocker.models.User;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable(value="id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable(value="id") Long id, @RequestBody Item item){
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.update(id, item));
    }

    @GetMapping(path="/all")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getAll());
    }
}
