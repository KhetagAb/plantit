package ru.tinkoff.landscapeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.landscapeservice.dao.model.Client;
import ru.tinkoff.landscapeservice.service.ClientService;

import java.util.Optional;
import java.util.UUID;

// TODO: transfer to DTO

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService service;

    @PostMapping
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @GetMapping("/{id}")
    public Optional<Client> get(@PathVariable("id") UUID id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Optional<Object> update(@PathVariable("id") UUID id, @RequestBody Client client) {
        return service.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
