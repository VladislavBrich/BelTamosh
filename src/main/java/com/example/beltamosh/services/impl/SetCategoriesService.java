package com.example.beltamosh.services.impl;

import com.example.beltamosh.dto.ResumeRequestDto;
import com.example.beltamosh.hellpers.Categories;
import com.example.beltamosh.models.BadCompany;
import com.example.beltamosh.models.BadEmployee;
import com.example.beltamosh.repositories.BadCompanyRepo;
import com.example.beltamosh.repositories.BadEmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SetCategoriesService {
    private final BadEmployeeRepo employeeRepo;
    private final BadCompanyRepo badCompanyRepo;

    /**
     * The method accepts the ResumeRequestDto object and then checks whether this object can be assigned to the candidates
     * of the priority category:
     **/
    void isFirstPriorityCategories(ResumeRequestDto resume) {
        boolean isSalaryValid = resume.getSalary() > 1000 && resume.getSalary() < 2000;
        String middleSkill = "Middle";
        boolean isMiddleLevel = resume.getSkillLevel().equals(middleSkill);
        boolean isSkillsValid = resume.getSkills().size() >= 7;
        if (isMiddleLevel && isSalaryValid && isSkillsValid && !isBadCompany(resume) && !isBadEmployee(resume)) {
            resume.setCategories(Categories.FirstPriority);
        }
    }

    /**
     * The method accepts the ResumeRequestDto object and then checks whether this object can be assigned to the candidates
     * of the second priority category:
     **/
    void isSecondPriorityCategories(ResumeRequestDto resume) {
        String juniorSkillLevel = "Junior";
        String seniorSkillLevel = "Senior";
        boolean isJuniorValid = ((resume.getSalary() > 0 && resume.getSalary() < 1000)
                && resume.getSkillLevel().equals(juniorSkillLevel));
        boolean isSeniorValid = ((resume.getSalary() > 2000 && resume.getSalary() <= 3000)
                && resume.getSkillLevel().equals(seniorSkillLevel));
        boolean isSkillValid = resume.getSkills().size() < 7;
        if ((isJuniorValid || isSeniorValid) && isSkillValid && !isBadCompany(resume) && !isBadEmployee(resume)) {
            resume.setCategories(Categories.SecondPriority);
        }
    }

    /**
     * The method accepts the ResumeRequestDto object and then checks whether this object can be assigned to the candidates
     * of the last priority category:
     **/
    void isLastPriorityCategories(ResumeRequestDto resume) {
        boolean isSalaryValid = resume.getSalary() > 3000;
        if (isSalaryValid && !isBadEmployee(resume)) {
            resume.setCategories(Categories.LastPriority);
        }
    }

    /**
     * The method accepts the ResumeRequestDto object and then checks whether this object can be assigned to the candidates
     * of the rejection priority category:
     **/
    void isRejectionCategories(ResumeRequestDto resume) {
        if (isBadEmployee(resume)) {
            resume.setCategories(Categories.Rejection);
        }
    }


    boolean isBadCompany(ResumeRequestDto resumeRequestDto) {
        List<BadCompany> badCompanies = badCompanyRepo.findAll();
        return badCompanies.stream().map(BadCompany::getName)
                .filter(it -> it.equals(resumeRequestDto.getPreviousJob()))
                .toList().size() > 0;
    }

    boolean isBadEmployee(ResumeRequestDto resumeRequestDto) {
        List<BadEmployee> badEmployees = employeeRepo.findAll();
        return badEmployees.stream().map(BadEmployee::getFullName)
                .filter(it -> it.equals(resumeRequestDto.getFullName()))
                .toList().size() > 0;
    }
}



