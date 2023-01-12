package com.example.springbootdocker.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudServiceInterface<T> {
    public T create(T item);
    public T update(Long id, T item);
    public Optional<T> delete(Long id);
    public Optional<T> getOne(Long id);
    public List<T> getAll();
}
