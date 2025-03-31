package com.buynonsense.ChronoGarden.scheduler;

import com.buynonsense.ChronoGarden.model.Plant;
import com.buynonsense.ChronoGarden.repository.PlantRepository;
import com.buynonsense.ChronoGarden.service.PlantGrowthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Component
public class PlantDecayScheduler {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantGrowthService plantGrowthService;

    // 每12小时执行一次正常衰减
    @Scheduled(fixedRate = 12 * 60 * 60 * 1000)
    public void normalDecay() {
        List<Plant> plants = plantRepository.findByIsWitheredFalse();
        for (Plant plant : plants) {
            if (plant.getLastNormalDecayTime() != null &&
                    ChronoUnit.HOURS.between(plant.getLastNormalDecayTime(), LocalDateTime.now()) >= 12) {
                plantGrowthService.applyDecay(plant, "normal");
            }
        }
    }

    // 每24小时执行一次随机衰减
    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void randomDecay() {
        List<Plant> plants = plantRepository.findByIsWitheredFalse();
        Random random = new Random();
        String[] decayTypes = { "drought", "pest", "coldwave" };

        for (Plant plant : plants) {
            if (plant.getLastRandomDecayTime() != null &&
                    ChronoUnit.HOURS.between(plant.getLastRandomDecayTime(), LocalDateTime.now()) >= 24) {
                String decayType = decayTypes[random.nextInt(decayTypes.length)];
                plantGrowthService.applyDecay(plant, decayType);
            }
        }
    }
}