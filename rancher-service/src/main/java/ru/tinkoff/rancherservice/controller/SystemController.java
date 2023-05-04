package ru.tinkoff.rancherservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.rancherservice.service.SystemService;

@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    private final static String RANCHER_SERVICE_STATUS_TEMPLATE = "{ \"RancherService\": \"%s\" }";

    @GetMapping("liveness")
    public ResponseEntity<String> getLiveness() {
        String status = RANCHER_SERVICE_STATUS_TEMPLATE.formatted(systemService.getLiveness());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("readiness")
    public ResponseEntity<String> getReadiness() {
        String status = RANCHER_SERVICE_STATUS_TEMPLATE.formatted(systemService.getReadiness());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
