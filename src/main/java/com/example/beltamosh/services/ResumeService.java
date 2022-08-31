package com.example.beltamosh.services;

import com.example.beltamosh.dto.ResumeRequestDto;
import com.example.beltamosh.models.Skill;
import org.springframework.ui.Model;

import java.util.List;

public interface ResumeService {
    void sendResume(ResumeRequestDto resumeRequestDto, Model model);
    void existByName (String name);


}
