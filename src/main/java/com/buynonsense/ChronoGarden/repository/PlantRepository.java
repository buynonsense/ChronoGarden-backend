package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}