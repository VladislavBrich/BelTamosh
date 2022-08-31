package com.example.beltamosh.controllers;

import com.example.beltamosh.models.Skill;
import com.example.beltamosh.services.impl.SkillsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
@AllArgsConstructor
public class SkillController {
    private final SkillsServiceImpl skillsService;

    /**
     * The method returns a list of all Skill
     **/

    @GetMapping()
    public List<Skill> getAllSkills() {
        return skillsService.getAll();
    }

    /**
     * The method adds a Skill object
     **/

    @PostMapping("/add")
    public void addSkillByName(@RequestParam String name) {
        skillsService.addSkill(name);
    }

    /**
     * The method deletes the Skill object by the name of the object
     **/

    @DeleteMapping("/delete")
    public void deleteSkillByName(@RequestParam String name) {
        skillsService.deleteByName(name);
    }
}
