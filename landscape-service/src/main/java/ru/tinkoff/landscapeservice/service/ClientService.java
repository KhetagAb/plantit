package ru.tinkoff.landscapeservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.landscapeservice.dao.model.Client;
import ru.tinkoff.landscapeservice.dao.repository.ClientRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }

    public Optional<Client> get(UUID id) {
        return repository.findById(id);
    }

    public Optional<Object> update(UUID id, Client client) {
        Optional<Client> updatingClientO = repository.findById(id);

        if (updatingClientO.isEmpty()) {
            return Optional.empty();
        }

        Client updatingClient = updatingClientO.get();

        updatingClient.setLogin(client.getLogin());
        updatingClient.setEmail(client.getEmail());
        updatingClient.setPhone(client.getPhone());
        updatingClient.setLatitude(client.getLatitude());
        updatingClient.setLongitude(client.getLongitude());

        return Optional.of(repository.save(updatingClient));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
