package com.example.beltamosh.services;

import com.example.beltamosh.models.BadCompany;
import com.example.beltamosh.models.Skill;

import java.util.List;

public interface SkillsService {
    void addSkill (String name);

    List<Skill> getAll ();

    void deleteByName (String name);
}
