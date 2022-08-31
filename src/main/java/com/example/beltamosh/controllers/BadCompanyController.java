package com.example.beltamosh.controllers;

import com.example.beltamosh.models.BadCompany;
import com.example.beltamosh.services.impl.BadCompanyServiceImpl;
import com.example.beltamosh.services.impl.SkillsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/badCompany", produces = MediaType.APPLICATION_JSON_VALUE)
public class BadCompanyController {
    private final BadCompanyServiceImpl badCompanyService;
/**
 * The method returns a list of all BadCompany
 **/
    @GetMapping
    public List<BadCompany> getAll() {
        return badCompanyService.getAll();
    }
/**
 * The method adds a BadCompany object
 **/
    @PostMapping("/add")
    public void addBadCompanyByName(@RequestParam String name) {
        badCompanyService.addBadCompany(name);
    }
/**
 * The method deletes the BadCompany object by the name of the object
 **/
    @DeleteMapping("/delete")
    public void deleteBadCompanyByName(@RequestParam String name) {
        badCompanyService.deleteByName(name);
    }
}
