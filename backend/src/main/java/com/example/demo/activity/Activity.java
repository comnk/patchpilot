package com.example.demo.activity;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Activity {

    private String name;
    private String description;
    private String category;
    private String location;
    private List<String> interests;
    private double cost;
    private int durationMinutes;
    private int travelMinutes;

    public Activity(String name, String description, String category, String location, List<String> interests,
            double cost, int durationMinutes, int travelMinutes) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.location = location;
        this.interests = interests;
        this.cost = cost;
        this.durationMinutes = durationMinutes;
        this.travelMinutes = travelMinutes;
    }
}
