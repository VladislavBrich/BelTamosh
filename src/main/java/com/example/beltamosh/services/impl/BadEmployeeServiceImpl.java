package com.example.beltamosh.services.impl;

import com.example.beltamosh.exception.BadRequestException;
import com.example.beltamosh.exception.NotFoundException;
import com.example.beltamosh.models.BadEmployee;
import com.example.beltamosh.repositories.BadEmployeeRepo;
import com.example.beltamosh.services.BadEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BadEmployeeServiceImpl implements BadEmployeeService {

    private final BadEmployeeRepo badEmployeeRepo;

    /**
     * The method takes the name BadEmployee checks for the presence of such a name in the database, if the name already
     * exists, the method returns an exception of the type BadRequestException, otherwise it creates a BadEmployee object
     * with the name parameter
     **/
    @Override
    public void addBadEmployee(String name) {
        if (badEmployeeRepo.existsByFullName(name)) {
            throw new BadRequestException(String.format("this BadEmployee \"%s\"  already exists", name)
            );
        }
        BadEmployee badEmployee = new BadEmployee(name);
        badEmployeeRepo.save(badEmployee);
    }

    @Override
    public List<BadEmployee> getAll() {
        return badEmployeeRepo.findAll();
    }

    /**
     * The method deletes the BadCompany object by the name parameter
     **/

    @Override
    public void deleteByName(String name) {
        if (badEmployeeRepo.existsByFullName(name)) {
            badEmployeeRepo.deleteByFullName(name);
        } else throw new NotFoundException(
                String.format("BadEmployee with name " + name + " is not exist")
        );
    }
}

