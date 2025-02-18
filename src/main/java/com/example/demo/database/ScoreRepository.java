package com.example.demo.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository


public interface ScoreRepository
    extends CrudRepository<ScoreEntity, Long> {
}

