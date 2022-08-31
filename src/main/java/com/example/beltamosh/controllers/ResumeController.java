package com.example.beltamosh.controllers;

import com.example.beltamosh.dto.ResumeRequestDto;
import com.example.beltamosh.models.Resume;
import com.example.beltamosh.models.Skill;
import com.example.beltamosh.services.impl.ResumeServiceImpl;
import com.example.beltamosh.services.impl.SkillsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/resume")
public class ResumeController {

    private final ResumeServiceImpl resumeService;
    private final SkillsServiceImpl skillsService;

    /**
     * Method for obtaining a resume form
     **/

    @GetMapping
    public String main(Model model) {
        model.addAttribute("resume", new Resume());
        return "resume";
    }

    /**
     * A method for obtaining and processing data from a completed resume form
     **/

    @PostMapping
    public RedirectView sendResume(
            @ModelAttribute("form") @RequestBody ResumeRequestDto resumeRequestDto, Model model) {
        resumeService.sendResume(resumeRequestDto, model);
        return new RedirectView("/");
    }

    /**
     * Method for displaying Skill objects from the database on a multi-button in the resume form
     **/

    @ModelAttribute("allSkills")
    public List<Skill> validSkills() {
        return skillsService.getAll();
    }

    /**
     * A method for displaying resume objects from a database with a FirstPriority category
     **/

    @GetMapping("/firstPriority")
    public String getByFirstPriority(Model model) {
        resumeService.getByFirstPriorityCategories(model);
        return "firstPriority";
    }

    /**
     * A method for displaying resume objects from a database with a SecondPriority category
     **/

    @GetMapping("/secondPriority")
    public String getBySecondPriority(Model model) {
        resumeService.getBySecondPriorityCategories(model);
        return "secondPriority";
    }

    /**
     * A method for displaying resume objects from a database with a LastPriority category
     **/

    @GetMapping("/lastPriority")
    public String getByLastPriority(Model model) {
        resumeService.getByLastPriorityCategories(model);
        return "lastPriority";
    }

    /**
     * A method for displaying resume objects from a database with a RegectionPriority category
     **/

    @GetMapping("/rejectionPriority")
    public String getByRejectionPriority(Model model) {
        resumeService.getByRejectionCategories(model);
        return "rejectionPriority";
    }
}
