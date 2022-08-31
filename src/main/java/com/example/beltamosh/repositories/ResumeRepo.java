package com.example.beltamosh.repositories;

import com.example.beltamosh.models.Resume;
import com.example.beltamosh.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Long> {
    boolean existsByFullName(String fullName);

    @Query(value = "select n from Resume n where n.categories='FirstPriority'")
    List<Resume> findAllByCategoriesFirstPriority();

    @Query(value = "select n from Resume n where n.categories='SecondPriority'")
    List<Resume> findAllByCategoriesSecondPriority();

    @Query(value = "select n from Resume n where n.categories='LastPriority'")
    List<Resume> findAllByCategoriesLastPriority();

    @Query(value = "select n from Resume n where n.categories='Rejection'")
    List<Resume> findAllByCategoriesRejection();
}
