package com.example.beltamosh.services;

import com.example.beltamosh.models.BadCompany;
import com.example.beltamosh.models.BadEmployee;

import java.util.List;

public interface BadEmployeeService {
    void addBadEmployee (String name);

    List<BadEmployee> getAll ();

    void deleteByName (String name);
}
