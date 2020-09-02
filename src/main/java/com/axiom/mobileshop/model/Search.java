package com.axiom.mobileshop.model;

import java.util.Arrays;
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
        List<String> paramsWhichNeedRegexCompare = Arrays.asList("announceDate", "phone","sim","gps","battery");
        List searchResult = allMobile.parallelStream().filter( mobileData -> {
            for(String param : params) {
                if(mobileData.getValue(param) == null) {
                    throw new InvalidParameterException("Invalid Parameter passed - " + param);
                }
                if(paramsWhichNeedRegexCompare.contains(param)) {
                    if(!mobileData.getValue(param).toLowerCase().contains(queryParams.get(param).toLowerCase())) {
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
