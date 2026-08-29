package com.example.demo.exploration;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "explorations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Exploration {
    @Id
    private UUID id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer duration;

    @Getter
    @Setter
    private Integer budget;

    public Exploration(UUID id, String name, Integer duration, Integer budget) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.budget = budget;
    }
}
