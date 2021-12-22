package com.service.impl;

import com.domain.Role;
import com.repository.RoleRepository;
import com.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements CRUDService<Role> {

    RoleRepository repository;

    @Override
    public void add(Role role) {
        repository.save(role);
    }

    @Override
    public void update(Role role) {
        repository.save(role);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Role getById(int id) {
        return repository.findById(id).get();
    }
}
