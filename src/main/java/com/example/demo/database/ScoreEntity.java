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
public class ScoreEntity {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long scoreId;
    private int tries;
    private float time;
}
