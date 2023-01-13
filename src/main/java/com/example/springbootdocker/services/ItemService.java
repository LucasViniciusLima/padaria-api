package com.example.springbootdocker.services;

import com.example.springbootdocker.dtos.ItemDto;
import com.example.springbootdocker.enums.Category;
import com.example.springbootdocker.interfaces.CrudServiceInterface;
import com.example.springbootdocker.models.Item;
import com.example.springbootdocker.models.User;
import com.example.springbootdocker.repositories.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements CrudServiceInterface<Item, ItemDto> {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(ItemDto item) {
        var itemModel = new Item();
        itemModel.setName(item.getName());
        itemModel.setCategory(Category.valueOf(item.getCategory()));
        itemModel.setPrice(item.getPrice());
        return itemRepository.save(itemModel);
    }

    @Override
    public Item update(Long id, Item item) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (!itemOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        item.setId(id);
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> delete(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (!itemOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        itemRepository.deleteById(id);
        return itemOptional;
    }

    @Override
    public Optional<Item> getOne(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (!itemOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return itemOptional;
    }

    @Override
    public List<Item> getAll() {
        List<Item> users = new ArrayList<>();
        itemRepository.findAll().forEach(users::add);
        return users;
    }
}
