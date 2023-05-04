package ru.tinkoff.rancherservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    private final ApplicationAvailability applicationAvailability;

    @Autowired
    public SystemService(ApplicationAvailability applicationAvailability) {
        this.applicationAvailability = applicationAvailability;
    }


    /**
     * Indicates the liveness of the application
     * @return liveness probe as enum {@link LivenessState}
     */
    public LivenessState getLiveness() {
        return applicationAvailability.getLivenessState();
    }

    /**
     * Indicates the readiness of the application
     * @return readiness probe as enum {@link ReadinessState}
     */
    public ReadinessState getReadiness() {
        return applicationAvailability.getReadinessState();
    }
}
