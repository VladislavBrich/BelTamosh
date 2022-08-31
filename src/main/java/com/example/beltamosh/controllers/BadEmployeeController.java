package com.example.beltamosh.controllers;

import com.example.beltamosh.models.BadEmployee;
import com.example.beltamosh.services.impl.BadEmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/badEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BadEmployeeController {
    private final BadEmployeeServiceImpl badEmployeeService;

    /**
     * The method returns a list of all BadCompany
     **/

    @GetMapping
    public List<BadEmployee> getAll() {
        return badEmployeeService.getAll();
    }

    /**
     * The method adds a BadEmployee object
     **/

    @PostMapping("/add")
    public void addBadCompanyByName(@RequestParam String name) {
        badEmployeeService.addBadEmployee(name);
    }

    /**
     * The method deletes the BadCompany object by the name of the object
     **/

    @DeleteMapping("/delete")
    public void deleteBadCompanyByName(@RequestParam String name) {
        badEmployeeService.deleteByName(name);
    }
}
