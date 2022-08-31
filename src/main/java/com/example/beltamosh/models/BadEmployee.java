package com.example.beltamosh.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class BadEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "fullName")
    private String fullName;

    public BadEmployee(String fullName) {
        this.fullName = fullName;
    }
}
