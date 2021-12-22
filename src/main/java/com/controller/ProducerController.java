package com.controller;
import com.domain.Producer;
import com.service.ProducerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ProducerController {
    ProducerService service;

    @PostMapping
    public void save(@RequestBody Producer producer) {
        service.add(producer);
    }

    @PutMapping
    public void update(@RequestBody Producer producer) {
        service.update(producer);
    }

    @GetMapping(value = "/{id}")
    public Producer getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable("id") int id) {
        service.getById(id);
    }
}
