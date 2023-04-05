package ru.tinkoff.landscapeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.tinkoff.landscapeservice.properties.ServicesProperties;

@SpringBootApplication
@EnableConfigurationProperties({ServicesProperties.class})
public class LandscapeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandscapeServiceApplication.class, args);
    }

}
