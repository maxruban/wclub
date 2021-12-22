package com.controller;

import com.domain.Order;
import com.service.OrderService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class OrderController {

    OrderService service;

    @PostMapping
    public void save(@RequestBody Order order) {
        service.add(order);
    }

    @PutMapping
    public void update(@RequestBody Order order) {
        service.update(order);
    }

    @GetMapping(value = "/{id}")
    public Order getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable("id") int id) {
        service.getById(id);
    }

}
