package com.controller;

import com.domain.Product;
import com.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ProductController {
    ProductService service;

    @PostMapping
    public void save(@RequestBody Product product) {
        service.add(product);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        service.update(product);
    }

    @GetMapping(value = "/{id}")
    public Product getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable("id") int id) {
        service.getById(id);
    }
}
