package ru.tinkoff.landscapeservice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.landscapeservice.dao.model.ClientType;

public interface ClientTypeRepository extends JpaRepository<ClientType, Integer> {
}
