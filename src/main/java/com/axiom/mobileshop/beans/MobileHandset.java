package com.axiom.mobileshop.beans;

import org.springframework.stereotype.Component;

@Component
public class MobileHandset {
    private String id;
    private String brand;
    private String phone;
    private String picture;
    private Release release;
    private String sim;
    private String resolution;
    private Hardware hardware;

    public MobileHandset() {}

    public MobileHandset(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public String getValue(String key) {
        switch (key) {
            case "id":
                return getId();
            case "brand":
                return getBrand();
            case "phone":
                return getPhone();
            case "picture":
                return getPicture();
            case "sim":
                return getSim();
            case "resolution":
                return getResolution();
            case "announceDate":
                return getRelease().getAnnounceDate();
            case "priceEur":
                return getRelease().getPriceEur();
            case "audioJack":
                return getHardware().getAudioJack();
            case "gps":
                return getHardware().getGps();
            case "battery":
                return getHardware().getBattery();
        }
        return null;
    }

}
