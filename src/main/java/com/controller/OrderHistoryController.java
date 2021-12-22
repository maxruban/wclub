package com.controller;

import com.domain.OrderHistory;
import com.domain.Producer;
import com.service.CRUDService;
import com.service.ProducerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order-history")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class OrderHistoryController {
    CRUDService<OrderHistory> service;

    @PostMapping
    public void save(@RequestBody OrderHistory history) {
        service.add(history);
    }

    @PutMapping
    public void update(@RequestBody OrderHistory history) {
        service.update(history);
    }

    @GetMapping(value = "/{id}")
    public OrderHistory getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable("id") int id) {
        service.getById(id);
    }
}
