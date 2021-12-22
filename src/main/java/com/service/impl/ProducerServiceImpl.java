package com.service.impl;

import com.domain.Producer;
import com.repository.ProducerRepository;
import com.service.ProducerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProducerServiceImpl implements ProducerService {

    ProducerRepository repository;

    @Override
    public void add(Producer producer) {
        repository.save(producer);
    }

    @Override
    public void update(Producer producer) {
        repository.save(producer);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Producer getById(int id) {
        return repository.findById(id).get();
    }
}
