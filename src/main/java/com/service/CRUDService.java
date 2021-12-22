package com.service;

public interface CRUDService<T> {
    void add(T t);
    void update(T t);
    void deleteById(int id);
    T getById(int id);

}
