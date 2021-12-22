package com.service.impl;

import com.domain.Product;
import com.domain.enums.Body;
import com.repository.ProductRepository;
import com.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Handler;

@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductRepository repository;

    @Override
    public void add(Product product) {
        repository.save(product);
    }

    @Override
    public void update(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return repository.findById(id).get();
    }
}
