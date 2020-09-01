package com.axiom.mobileshop.beans;

import org.springframework.stereotype.Component;

@Component
public class Hardware {
    private String audioJack;
    private String gps;
    private String battery;

    public Hardware() {}

    public Hardware(String audioJack, String gps, String battery) {
        this.audioJack = audioJack;
        this.gps = gps;
        this.battery = battery;
    }

    public String getAudioJack() {
        return audioJack;
    }

    public void setAudioJack(String audioJack) {
        this.audioJack = audioJack;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }
}
