package com.service.impl;

import com.domain.ProductPreference;
import com.repository.ProductPreferenceRepository;
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
public class ProductPreferenceServiceImpl implements CRUDService<ProductPreference> {

    ProductPreferenceRepository repository;

    @Override
    public void add(ProductPreference productPreference) {
        productPreference.setCreated(LocalDate.now());
        repository.save(productPreference);
    }

    @Override
    public void update(ProductPreference productPreference) {
        productPreference.setCreated(LocalDate.now());
        repository.save(productPreference);
    }

    @Override
    public void deleteById(int id) {
            repository.deleteById(id);
    }

    @Override
    public ProductPreference getById(int id) {
        return repository.findById(id).get();
    }
}
