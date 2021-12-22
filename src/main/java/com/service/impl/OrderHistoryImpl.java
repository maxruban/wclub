package com.service.impl;

import com.domain.OrderHistory;
import com.repository.OrderHistoryRepository;
import com.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderHistoryImpl implements CRUDService<OrderHistory> {

    OrderHistoryRepository repository;

    @Override
    public void add(OrderHistory orderHistory) {
       orderHistory.setDate(LocalDate.now());
       repository.save(orderHistory);
    }

    @Override
    public void update(OrderHistory orderHistory) {
        orderHistory.setDate(LocalDate.now());
        repository.save(orderHistory);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public OrderHistory getById(int id) {
        return repository.findById(id).get();
    }
}
