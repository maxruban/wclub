package com.controller;

import com.domain.ProductPreference;
import com.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reference")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ProductPreferenceController {

    CRUDService<ProductPreference> service;

    @PostMapping
    public void save(@RequestBody ProductPreference preference) {
        service.add(preference);
    }

    @PutMapping
    public void update(@RequestBody ProductPreference preference) {
        service.update(preference);
    }

    @GetMapping(value = "/{id}")
    public ProductPreference getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable("id") int id) {
        service.getById(id);
    }
}
