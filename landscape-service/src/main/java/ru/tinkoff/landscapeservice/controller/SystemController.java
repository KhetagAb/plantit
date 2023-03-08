package ru.tinkoff.landscapeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

    private final static String TEMPORARY_READINESS_JSON = "{ \"LandscapeService\": \"OK\" }";

    @GetMapping("liveness")
    public ResponseEntity<Void> getLiveness() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("readiness")
    public ResponseEntity<String> getReadiness() {
        return new ResponseEntity<>(TEMPORARY_READINESS_JSON, HttpStatus.OK);
    }
}
