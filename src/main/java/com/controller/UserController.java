package com.controller;


import com.domain.User;
import com.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class UserController {
    UserService service;

    @PostMapping
    public void save(@RequestBody User user) {
        service.add(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        service.update(user);
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.getById(id);
    }
}
