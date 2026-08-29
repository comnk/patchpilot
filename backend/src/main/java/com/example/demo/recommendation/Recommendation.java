package com.example.demo.recommendation;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recommendations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recommendation {

    @Id
    private UUID id;

    public Recommendation(UUID id) {
        this.id = id;
    }
}
