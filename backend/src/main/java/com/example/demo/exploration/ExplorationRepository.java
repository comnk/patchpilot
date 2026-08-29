package com.example.demo.exploration;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExplorationRepository extends JpaRepository<Exploration, UUID> {

}
