package com.axiom.mobileshop.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTest {

    @Test
    public void testPopulateCache() {
        Cache cache = new Cache();
        Assert.assertEquals(105, cache.getCache().size());
    }
}
