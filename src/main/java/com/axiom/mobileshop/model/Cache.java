package com.axiom.mobileshop.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.axiom.mobileshop.beans.MobileHandset;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.net.ssl.HttpsURLConnection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Cache {

    private String url;
    private List<MobileHandset> cache;

    public Cache() {
        this.url = "https://a511e938-a640-4868-939e-6eef06127ca1.mock.pstmn.io/handsets/list";
        initializeCache();
    }

    public List<MobileHandset> getCache() {
        return cache;
    }

    private void initializeCache() {
        try {
            URL url = new URL(this.url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            ObjectMapper objectMapper = new ObjectMapper();
            cache = Collections.unmodifiableList(Arrays.asList(objectMapper.readValue(reader, MobileHandset[].class)));
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception occured while loading cache - " + e.getMessage());
        }
    }



}
