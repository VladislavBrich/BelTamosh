package com.example.beltamosh.repositories;

import com.example.beltamosh.models.BadEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadEmployeeRepo extends JpaRepository<BadEmployee, Long> {
    boolean existsByFullName(String name);

    void deleteByFullName(String name);
}
