package com.example.beltamosh.services;

import com.example.beltamosh.models.BadCompany;

import java.util.List;

public interface BadCompanyService {

    void addBadCompany (String name);

    List<BadCompany> getAll ();

    void deleteByName (String name);
}
