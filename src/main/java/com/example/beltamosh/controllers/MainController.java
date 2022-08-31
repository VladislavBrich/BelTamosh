package com.example.beltamosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    /**
     * A method for displaying the main page where the user can choose to add a resume to him or view all the resumes
     **/

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main page");
        return "index";
    }

    /**
     * The method takes you to a page where the user selects one of the resume categories to view
     **/

    @GetMapping("/allResume")
    public String Recipes(Model model) {
        return "allResume";
    }
}
