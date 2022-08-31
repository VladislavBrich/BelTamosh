package com.example.beltamosh.repositories;

import com.example.beltamosh.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepo extends JpaRepository<Skill,Long> {
    boolean existsByName (String name);
    void deleteByName(String name);


}
