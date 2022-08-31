package com.example.beltamosh.dto;

import com.example.beltamosh.hellpers.Categories;
import com.example.beltamosh.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
/**
 * A class for accepting data from a resume form, processing, further validation, and converting it into a resume object
 * **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeRequestDto {
    @NonNull
    private String fullName;
    @NonNull
    private String previousJob;
    @NonNull
    private String desiredPosition;
    @NonNull
    private Categories categories;
    @NonNull
    private List<Skill> skills;
    @NonNull
    private String skillLevel;
    @NonNull
    private Long salary;
    @NonNull
    private String description;
}
