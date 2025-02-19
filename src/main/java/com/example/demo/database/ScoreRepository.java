package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository


public interface ScoreRepository
    extends JpaRepository<ScoreEntity, Long> {
}
