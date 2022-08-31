package com.example.beltamosh.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
@Data
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "skills")
    List<Resume> resumes;

    public Skill(String name) {
        this.name = name;
    }
}
