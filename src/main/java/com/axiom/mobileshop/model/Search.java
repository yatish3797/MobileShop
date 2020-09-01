package com.axiom.mobileshop.model;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.axiom.mobileshop.beans.MobileHandset;
import com.axiom.mobileshop.exception.InvalidParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Search {

    @Autowired
    private Cache cache;

    public List<MobileHandset> fetchSearchResult(Map<String, String> queryParams) {
        List<MobileHandset> allMobile = cache.getCache();
        Set<String> params = queryParams.keySet();
        List searchResult = allMobile.parallelStream().filter( mobileData -> {
            for(String param : params) {
                if(mobileData.getValue(param) == null) {
                    throw new InvalidParameterException("Invalid Parameter passed - " + param);
                }
                if(param.equalsIgnoreCase("announceDate")) {
                    if(!mobileData.getValue(param).contains(queryParams.get(param))) {
                        return false;
                    }
                } else {
                    if(!mobileData.getValue(param).equalsIgnoreCase(queryParams.get(param))) {
                        return false;
                    }
                }

            }
            return true;
        }).collect(Collectors.toList());
        return searchResult;
    }
}
