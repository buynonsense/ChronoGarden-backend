package com.buynonsense.ChronoGarden.service;

import com.buynonsense.ChronoGarden.model.Plant;
import com.buynonsense.ChronoGarden.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
public class PlantGrowthService {

    @Autowired
    private PlantRepository plantRepository;

    // 计算植物生长进度（天数）
    public long calculateGrowthDays(Plant plant) {
        if (plant.getGrowthStartTime() == null) {
            return 0;
        }

        if (plant.getIsWithered()) {
            return 0; // 枯萎状态，进度重置
        }

        // 濒危状态，生长停止
        if (isEndangered(plant)) {
            return calculateGrowthDaysUntilEndangered(plant);
        }

        return ChronoUnit.DAYS.between(plant.getGrowthStartTime(), LocalDateTime.now());
    }

    // 计算到达濒危状态时的生长天数
    private long calculateGrowthDaysUntilEndangered(Plant plant) {
        // 简化实现：假定从开始到当前时间的天数
        return ChronoUnit.DAYS.between(plant.getGrowthStartTime(), LocalDateTime.now());
    }

    // 根据生长天数获取生长阶段
    public String getGrowthStageByDays(long days) {
        if (days < 2)
            return "seed"; // 0-2天：种子期
        if (days < 5)
            return "sprout"; // 2-5天：发芽期
        if (days < 10)
            return "flower"; // 5-10天：开花期
        return "fruit"; // 10-14天：结果期
    }

    // 计算植物状态（综合指标）
    public int calculateHealthStatus(Plant plant) {
        // 如果任一指标为0，则植物为枯萎状态
        if (plant.getWaterLevel() <= 0 || plant.getLightLevel() <= 0 || plant.getNutrientLevel() <= 0) {
            return 0;
        }

        // 计算平均值作为健康状态
        return (plant.getWaterLevel() + plant.getLightLevel() + plant.getNutrientLevel()) / 3;
    }

    // 判断植物是否处于濒危状态
    public boolean isEndangered(Plant plant) {
        int status = calculateHealthStatus(plant);
        return status > 0 && status <= 30;
    }

    // 更新植物生长状态
    public Plant updatePlantGrowthState(Plant plant) {
        // 计算生长天数
        long growthDays = calculateGrowthDays(plant);

        // 更新生长阶段
        String newStage = getGrowthStageByDays(growthDays);
        plant.setGrowthStage(newStage);

        // 计算健康状态
        int healthStatus = calculateHealthStatus(plant);

        // 判断是否枯萎
        if (healthStatus == 0) {
            plant.setIsWithered(true);
        }

        // 判断是否完成生长周期
        if (growthDays >= 14 && "fruit".equals(newStage)) {
            plant.setIsCompleted(true);
        }

        return plantRepository.save(plant);
    }


    // 执行衰减
    public Plant applyDecay(Plant plant, String decayType) {
        Random random = new Random();

        switch (decayType) {
            case "normal":
                // 正常衰减：各项减5-10点
                int normalDecay = 5 + random.nextInt(6);
                plant.setWaterLevel(Math.max(0, plant.getWaterLevel() - normalDecay));
                plant.setLightLevel(Math.max(0, plant.getLightLevel() - normalDecay));
                plant.setNutrientLevel(Math.max(0, plant.getNutrientLevel() - normalDecay));
                plant.setLastNormalDecayTime(LocalDateTime.now());
                break;

            case "drought":
                // 干旱事件：水分减20-40点
                int droughtDecay = 20 + random.nextInt(21);
                plant.setWaterLevel(Math.max(0, plant.getWaterLevel() - droughtDecay));
                break;

            case "pest":
                // 虫害事件：养分减10-20点，阳光减5-10点
                int pestNutrientDecay = 10 + random.nextInt(11);
                int pestLightDecay = 5 + random.nextInt(6);
                plant.setNutrientLevel(Math.max(0, plant.getNutrientLevel() - pestNutrientDecay));
                plant.setLightLevel(Math.max(0, plant.getLightLevel() - pestLightDecay));
                break;

            case "coldwave":
                // 寒潮事件：阳光减15-30点，水分减10-20点
                int coldLightDecay = 15 + random.nextInt(16);
                int coldWaterDecay = 10 + random.nextInt(11);
                plant.setLightLevel(Math.max(0, plant.getLightLevel() - coldLightDecay));
                plant.setWaterLevel(Math.max(0, plant.getWaterLevel() - coldWaterDecay));
                break;
        }

        if (!decayType.equals("normal")) {
            plant.setLastRandomDecayTime(LocalDateTime.now());
        }

        return updatePlantGrowthState(plant);
    }

    // 启动生长
    public Plant startGrowth(Plant plant) {
        plant.setGrowthStartTime(LocalDateTime.now());
        plant.setWaterLevel(70);
        plant.setLightLevel(70);
        plant.setNutrientLevel(70);
        plant.setGrowthStage("seed");
        plant.setIsWithered(false);
        plant.setIsCompleted(false);
        plant.setLastNormalDecayTime(LocalDateTime.now());
        plant.setLastRandomDecayTime(LocalDateTime.now());

        return plantRepository.save(plant);
    }

    // 养护操作：浇水
    public Plant waterPlant(Plant plant) {
        int newLevel = Math.min(100, plant.getWaterLevel() + 60);
        plant.setWaterLevel(newLevel);
        return updatePlantGrowthState(plant);
    }

    // 养护操作：调整光照
    public Plant adjustLight(Plant plant) {
        int newLevel = Math.min(100, plant.getLightLevel() + 60);
        plant.setLightLevel(newLevel);
        return updatePlantGrowthState(plant);
    }

    // 养护操作：施肥
    public Plant fertilize(Plant plant) {
        int newLevel = Math.min(100, plant.getNutrientLevel() + 60);
        plant.setNutrientLevel(newLevel);
        return updatePlantGrowthState(plant);
    }

    // 养护操作：修剪
    public Plant prunePlant(Plant plant) {
        plant.setWaterLevel(Math.min(100, plant.getWaterLevel() + 15));
        plant.setLightLevel(Math.min(100, plant.getLightLevel() + 25));
        plant.setNutrientLevel(Math.min(100, plant.getNutrientLevel() + 20));
        return updatePlantGrowthState(plant);
    }
}