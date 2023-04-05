package ru.tinkoff.rancherservice.service;

import org.springframework.stereotype.Service;

@Service
public class SystemService {

    /**
     * Indicates if service is completely set upped
     * @return service readiness
     */
    public boolean getReadiness() {
        return true;
    }
}
