package ru.tinkoff.handymanservice.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.handymanservice.server.service.SystemService;

@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService service;

    private final static String HANDYMAN_SERVICE_STATUS_TEMPLATE = "{ \"HandymanService\": \"%s\" }";

    @GetMapping("liveness")
    public ResponseEntity<Void> getLiveness() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("readiness")
    public ResponseEntity<String> getReadiness() {
        HttpStatus httpStatus = service.getReadiness() ? HttpStatus.OK : HttpStatus.TOO_EARLY;
        return new ResponseEntity<>(
                HANDYMAN_SERVICE_STATUS_TEMPLATE.formatted(httpStatus.getReasonPhrase()),
                httpStatus
        );
    }
}
