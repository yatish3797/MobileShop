package com.axiom.mobileshop.beans;

import org.springframework.stereotype.Component;

@Component
public class Release {
    private String announceDate;
    private Integer priceEur;

    public Release() {}

    public Release(String announceDate, Integer priceEur) {
        this.announceDate = announceDate;
        this.priceEur = priceEur;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public Integer getPriceEur() {
        return priceEur;
    }

    public void setPriceEur(Integer priceEur) {
        this.priceEur = priceEur;
    }
}
