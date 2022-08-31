package com.example.beltamosh.services.impl;

import com.example.beltamosh.exception.BadRequestException;
import com.example.beltamosh.exception.NotFoundException;
import com.example.beltamosh.models.BadCompany;
import com.example.beltamosh.models.Skill;
import com.example.beltamosh.repositories.BadCompanyRepo;
import com.example.beltamosh.services.BadCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BadCompanyServiceImpl implements BadCompanyService {
    private final BadCompanyRepo badCompanyRepo;
/**
 * The method takes the name BadCompany checks for the presence of such a name in the database, if the name already
 * exists, the method returns an exception of the type BadRequestException, otherwise it creates a BadCompany object
 * with the name parameter
 * **/
    public void addBadCompany(String name) {
        if (badCompanyRepo.existsByName(name)) {
            throw new BadRequestException(String.format("this BadCompany \"%s\"  already exists", name)
            );
        }
        BadCompany badCompany = new BadCompany(name);
        badCompanyRepo.save(badCompany);
    }

    @Override
    public List<BadCompany> getAll() {
        return badCompanyRepo.findAll();
    }
/**
 * The method deletes the BadCompany object by the name parameter
 * **/
    @Override
    public void deleteByName(String name) {
        if (badCompanyRepo.existsByName(name)) {
            badCompanyRepo.deleteByName(name);
        } else throw new NotFoundException(
                String.format("BadCompany with name " + name + " is not exist")
        );
    }
}




