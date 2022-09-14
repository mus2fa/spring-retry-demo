package org.mustafa.springretrydemo.controller;

import org.mustafa.springretrydemo.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class DbController {

    @Autowired
    private DbService dbService;
    
    @GetMapping("nD/{number}")
    public String numberDivide(@PathVariable Long number) {
        return dbService.saveToDb(number);
    }
}
