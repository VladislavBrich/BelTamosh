package com.example.beltamosh.services.impl;

import com.example.beltamosh.dto.ResumeRequestDto;
import com.example.beltamosh.exception.BadRequestException;
import com.example.beltamosh.mapper.ResumeMapper;
import com.example.beltamosh.models.Resume;
import com.example.beltamosh.repositories.ResumeRepo;
import com.example.beltamosh.services.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@AllArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepo resumeRepo;
    private final SetCategoriesService setCategoriesService;
    private final ResumeMapper resumeMapper;
/**
 * The method takes a ResumeRequestDto object, checks by the name field whether such an object already exists, then
 * the object passes validation for belonging to one of the categories, and is converted into a Resume object
 * **/
    @Override
    public void sendResume(ResumeRequestDto resumeRequestDto, Model model) {
        existByName(resumeRequestDto.getFullName());
        setCategoriesService.isFirstPriorityCategories(resumeRequestDto);
        setCategoriesService.isSecondPriorityCategories(resumeRequestDto);
        setCategoriesService.isLastPriorityCategories(resumeRequestDto);
        setCategoriesService.isRejectionCategories(resumeRequestDto);
        Resume resume = resumeMapper.ResumeDtoToResume(resumeRequestDto);
        resumeRepo.save(resume);
        model.addAttribute("resume", resume);
    }

    public void getByFirstPriorityCategories(Model model) {
        List<Resume> resumes = resumeRepo.findAllByCategoriesFirstPriority();
        model.addAttribute("resumes", resumes);
    }

    public void getBySecondPriorityCategories(Model model) {
        List<Resume> resumes = resumeRepo.findAllByCategoriesSecondPriority();
        model.addAttribute("resumes", resumes);
    }

    public void getByLastPriorityCategories(Model model) {
        List<Resume> resumes = resumeRepo.findAllByCategoriesLastPriority();
        model.addAttribute("resumes", resumes);
    }

    public void getByRejectionCategories(Model model) {
        List<Resume> resumes = resumeRepo.findAllByCategoriesRejection();
        model.addAttribute("resumes", resumes);
    }

    @Override
    public void existByName(String fullName) {
        if (resumeRepo.existsByFullName(fullName)) {
            throw new BadRequestException(String.format("this user's \"%s\" resume already exists", fullName)
            );
        }
    }
}
