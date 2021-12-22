package com.controller;

import com.domain.Role;
import com.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class RoleController {
    CRUDService<Role> service;

    @PostMapping
    public void save(@RequestBody Role role) {
        service.add(role);
    }

    @PutMapping
    public void update(@RequestBody Role role) {
        service.update(role);
    }

    @GetMapping(value = "/{id}")
    public Role getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable("id") int id) {
        service.getById(id);
    }

}
