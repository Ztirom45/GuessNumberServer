package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface extending JPA
public interface LoggingRepository
    extends JpaRepository<LoggingEntity, Long> {
}

