package com.example.beltamosh.repositories;

import com.example.beltamosh.models.BadCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadCompanyRepo extends JpaRepository<BadCompany, Long> {
    boolean existsByName(String name);

    void deleteByName(String name);
}
