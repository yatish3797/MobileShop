package com.axiom.mobileshop.controller;

import java.util.List;
import java.util.Map;

import com.axiom.mobileshop.beans.MobileHandset;
import com.axiom.mobileshop.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile")
public class MobileHandsetController {

    @Autowired
    private Search search;

    @RequestMapping(method= RequestMethod.GET, value="/search")
    public List<MobileHandset> searchMobileHandsets(@RequestParam Map<String,String> allParams){
        return search.fetchSearchResult(allParams);
    }
}
