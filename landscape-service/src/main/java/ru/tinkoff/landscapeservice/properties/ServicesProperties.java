package ru.tinkoff.landscapeservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("services")
public class ServicesProperties {

    private List<String> handyman;
    private List<String> rancher;

    public List<String> getHandyman() {
        return handyman;
    }

    public List<String> getRancher() {
        return rancher;
    }

    public void setHandyman(List<String> handyman) {
        this.handyman = handyman;
    }

    public void setRancher(List<String> rancher) {
        this.rancher = rancher;
    }
}
