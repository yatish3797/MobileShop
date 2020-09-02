package com.axiom.mobileshop.model;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.axiom.mobileshop.beans.MobileHandset;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchTest {

    private List<MobileHandset> phoneData;

    @InjectMocks
    private Search search;

    @Mock
    private Cache cache;

    @BeforeEach
    public void mockDataSetup() {
        try {
            File file = new File("src/test/resources/phoneHandsetData.json");
            ObjectMapper objectMapper = new ObjectMapper();
            phoneData = Collections.unmodifiableList(Arrays.asList(objectMapper.readValue(file,  MobileHandset[].class)));

            Mockito.doReturn(phoneData).when(cache).getCache();
        } catch (Exception e) {
            System.out.println("Exception occurred while populating mock data");
        }
    }

    @Test
    public void testSingleParameterPriceEur() {
        Map params = new HashMap<String, String>();
        params.put("priceEur","200");
        List<MobileHandset> result = search.fetchSearchResult(params);
        Assert.assertEquals(10, result.size());
    }

    @Test
    public void testSingleParameterSim() {
        Map params = new HashMap<String, String>();
        params.put("sim","eSim");
        List<MobileHandset> result = search.fetchSearchResult(params);
        Assert.assertEquals(18, result.size());
    }

    @Test
    public void testMoreParameters() {
        Map params = new HashMap<String, String>();
        params.put("priceEur","200");
        params.put("announceDate","1999");
        List<MobileHandset> result = search.fetchSearchResult(params);
        Assert.assertEquals(2, result.size());
    }
}
