package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByEra(String era);

    // 添加获取非枯萎植物的方法
    List<Plant> findByIsWitheredFalse();
}