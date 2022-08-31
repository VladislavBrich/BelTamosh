package com.example.beltamosh.services;

import com.example.beltamosh.dto.ResumeRequestDto;
import org.springframework.ui.Model;

public interface ResumeService {
    void sendResume(ResumeRequestDto resumeRequestDto, Model model);
    void existByName (String name);


}
