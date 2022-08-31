package com.example.beltamosh.services.impl;

import com.example.beltamosh.exception.BadRequestException;
import com.example.beltamosh.exception.NotFoundException;
import com.example.beltamosh.models.Skill;
import com.example.beltamosh.repositories.SkillsRepo;
import com.example.beltamosh.services.SkillsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkillsServiceImpl implements SkillsService {
    private final SkillsRepo skillsRepo;

    @Override
    public void addSkill(String name) {
        if (skillsRepo.existsByName(name)) {
            throw new BadRequestException(String.format("this skill \"%s\"  already exists", name)
            );
        }
        Skill skill = new Skill(name);
        skillsRepo.save(skill);
    }

    @Override
    public List<Skill> getAll() {
        return skillsRepo.findAll();
    }

    @Override
    public void deleteByName(String name) {
        if (skillsRepo.existsByName(name)) {
            skillsRepo.deleteByName(name);
        } else throw new NotFoundException(
                String.format("Skill with name " + name + " is not exist")
        );
    }
}

