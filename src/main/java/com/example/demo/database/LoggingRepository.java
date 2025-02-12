package com.example.demo.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface extending CrudRepository
public interface LoggingRepository
    extends CrudRepository<LoggingEntity, Long> {
}

