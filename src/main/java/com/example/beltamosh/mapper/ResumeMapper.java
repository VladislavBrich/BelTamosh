package com.example.beltamosh.mapper;

import com.example.beltamosh.dto.ResumeRequestDto;
import com.example.beltamosh.models.Resume;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * The class takes a ResumeRequestDto object and converts it to a Resume object
 **/
@Component
@Data
public class ResumeMapper {

    public Resume ResumeDtoToResume(ResumeRequestDto resumeRequestDto) {
        return new Resume(
                resumeRequestDto.getFullName(),
                resumeRequestDto.getPreviousJob(),
                resumeRequestDto.getDesiredPosition(),
                resumeRequestDto.getSkillLevel(),
                resumeRequestDto.getSalary(),
                resumeRequestDto.getCategories(),
                resumeRequestDto.getDescription());
    }
}
