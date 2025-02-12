package com.example.demo.database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Class
public class LoggingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loggingId;
    private String loggingContent;
}
