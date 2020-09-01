package com.axiom.mobileshop.beans;

import org.springframework.stereotype.Component;

@Component
public class Release {
    private String announceDate;
    private String priceEur;

    public Release() {}

    public Release(String announceDate, String priceEur) {
        this.announceDate = announceDate;
        this.priceEur = priceEur;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public String getPriceEur() {
        return priceEur;
    }

    public void setPriceEur(String priceEur) {
        this.priceEur = priceEur;
    }
}
