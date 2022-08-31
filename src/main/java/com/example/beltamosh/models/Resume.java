package com.example.beltamosh.models;

import com.example.beltamosh.hellpers.Categories;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resumes")
@Data
@NoArgsConstructor
public class Resume implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    Long id;

    @Column()
    private String fullName;
    @Column()
    private String previousJob;

    @Column()
    private String desiredPosition;

    @Column()
    private String skillLevel;

    @Column()
    private Long salary;

    @Enumerated(EnumType.STRING)
    private Categories categories;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "resume_skills",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills = new ArrayList<>();

    @Column
    private String description;


    public Resume(String fullName, String previousJob, String desiredPosition, String skillLevel, Long salary,
                  Categories categories, List<Skill> skills, String description) {
        this.fullName = fullName;
        this.previousJob = previousJob;
        this.desiredPosition = desiredPosition;
        this.skillLevel = skillLevel;
        this.salary = salary;
        this.categories = categories;
        this.skills = skills;
        this.description = description;
    }

    public Resume(String fullName, String previousJob, String desiredPosition,
                  String skillLevel, Long salary, Categories categories, String description) {
        this.fullName = fullName;
        this.previousJob = previousJob;
        this.desiredPosition = desiredPosition;
        this.skillLevel = skillLevel;
        this.salary = salary;
        this.categories = categories;
        this.description = description;
    }
}





