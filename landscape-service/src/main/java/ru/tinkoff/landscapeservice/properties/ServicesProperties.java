package ru.tinkoff.landscapeservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("services")
public class ServicesProperties {

    private List<String> handymanUrls;
    private List<String> rancherUrls;

    public List<String> getHandymanUrls() {
        return handymanUrls;
    }

    public List<String> getRancherUrls() {
        return rancherUrls;
    }

    public void setHandymanUrls(List<String> handyman) {
        this.handymanUrls = handyman;
    }

    public void setRancherUrls(List<String> rancher) {
        this.rancherUrls = rancher;
    }
}
