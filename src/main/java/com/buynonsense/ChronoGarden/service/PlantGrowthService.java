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

        // 设置 growthDays
        plant.setGrowthDays((int) growthDays);

        // 保存植物（不覆盖 lastUpdatedTime）
        return plantRepository.save(plant);
    }

    // 执行衰减
    public Plant applyDecay(Plant plant, String decayType) {
        Random random = new Random();

        switch (decayType) {
            case "normal":
                applyNormalDecay(plant);
                break;

            case "drought":
                // 干旱事件：主要影响水分，但也略微影响养分
                int droughtWaterDecay = 20 + random.nextInt(21); // 20-40
                int droughtNutrientDecay = 2 + random.nextInt(5); // 2-6 (轻微影响)
                plant.setWaterLevel(Math.max(0, plant.getWaterLevel() - droughtWaterDecay));
                plant.setNutrientLevel(Math.max(0, plant.getNutrientLevel() - droughtNutrientDecay));
                break;

            case "pest":
                // 虫害事件：主要影响养分，中度影响光照，轻微影响水分
                int pestNutrientDecay = 10 + random.nextInt(11); // 10-20
                int pestLightDecay = 5 + random.nextInt(6); // 5-10
                int pestWaterDecay = 1 + random.nextInt(3); // 1-3 (轻微影响)
                plant.setNutrientLevel(Math.max(0, plant.getNutrientLevel() - pestNutrientDecay));
                plant.setLightLevel(Math.max(0, plant.getLightLevel() - pestLightDecay));
                plant.setWaterLevel(Math.max(0, plant.getWaterLevel() - pestWaterDecay));
                break;

            case "coldwave":
                // 寒潮事件：主要影响光照和水分，轻微影响养分
                int coldLightDecay = 15 + random.nextInt(16); // 15-30
                int coldWaterDecay = 10 + random.nextInt(11); // 10-20
                int coldNutrientDecay = 1 + random.nextInt(4); // 1-4 (轻微影响)
                plant.setLightLevel(Math.max(0, plant.getLightLevel() - coldLightDecay));
                plant.setWaterLevel(Math.max(0, plant.getWaterLevel() - coldWaterDecay));
                plant.setNutrientLevel(Math.max(0, plant.getNutrientLevel() - coldNutrientDecay));
                break;
        }

        if (!decayType.equals("normal")) {
            plant.setLastRandomDecayTime(LocalDateTime.now());
        }

        return updatePlantGrowthState(plant);
    }

    // 在applyNormalDecay方法中修改结果期的处理
    private void applyNormalDecay(Plant plant) {
        Random random = new Random();

        // 为不同属性设置不同的衰减范围，增加差异性
        // 水分: 范围更大，衰减更快(4-12)
        // 光照: 中等衰减(2-7)
        // 养分: 衰减较慢(1-5)
        int waterDecay = 4 + random.nextInt(9);
        int lightDecay = 2 + random.nextInt(6);
        int nutrientDecay = 1 + random.nextInt(5);

        // 加入调试输出，观察实际衰减值
        System.out.println("植物ID: " + plant.getId() +
                " 水分衰减: " + waterDecay +
                " 光照衰减: " + lightDecay +
                " 养分衰减: " + nutrientDecay);

        // 应用衰减值到各个属性
        plant.setWaterLevel(Math.max(0, plant.getWaterLevel() - waterDecay));
        plant.setLightLevel(Math.max(0, plant.getLightLevel() - lightDecay));
        plant.setNutrientLevel(Math.max(0, plant.getNutrientLevel() - nutrientDecay));
        plant.setLastNormalDecayTime(LocalDateTime.now());

        // 特殊处理结果期的植物 - 保持原有逻辑
        if ("fruit".equals(plant.getGrowthStage())) {
            // 获取结果期开始时间
            LocalDateTime fruitTime = plant.getLastUpdatedTime();
            LocalDateTime now = LocalDateTime.now();

            // 如果果实已经超过3天未收获，将会枯萎
            if (fruitTime != null && ChronoUnit.DAYS.between(fruitTime, now) >= 3) {
                plant.setIsWithered(true);
                // 将水分、光照和养分都设为0
                plant.setWaterLevel(0);
                plant.setLightLevel(0);
                plant.setNutrientLevel(0);
            }
        }

        plantRepository.save(plant);
    }

    /**
     * 启动植物生长周期
     */
    public Plant startGrowth(Plant plant) {
        // 设置初始状态
        plant.setWaterLevel(70);
        plant.setLightLevel(70);
        plant.setNutrientLevel(70);
        plant.setGrowthStage("seed");
        plant.setGrowthStartDate(LocalDateTime.now());
        plant.setLastWateredTime(LocalDateTime.now());
        plant.setLastLightAdjustmentTime(LocalDateTime.now());
        plant.setLastFertilizedTime(LocalDateTime.now());
        plant.setLastPrunedTime(LocalDateTime.now());
        plant.setIsWithered(false);
        plant.setIsCompleted(false);

        // 保存更改
        return plantRepository.save(plant);
    }

    // 养护操作：浇水
    public Plant waterPlant(Plant plant) {
        int newLevel = Math.min(100, plant.getWaterLevel() + 30);
        plant.setWaterLevel(newLevel);
        return updatePlantGrowthState(plant);
    }

    // 养护操作：调整光照
    public Plant adjustLight(Plant plant) {
        int newLevel = Math.min(100, plant.getLightLevel() + 30);
        plant.setLightLevel(newLevel);

        LocalDateTime now = LocalDateTime.now();
        plant.setLastLightAdjustmentTime(now);
        plant.setLastNormalDecayTime(now);

        // 调试日志：确认保存前的光照值
        System.out.println("保存前光照值: " + plant.getLightLevel());

        return plantRepository.save(plant);
    }
    // 养护操作：施肥
    public Plant fertilize(Plant plant) {
        int newLevel = Math.min(100, plant.getNutrientLevel() + 30);
        plant.setNutrientLevel(newLevel);
        return updatePlantGrowthState(plant);
    }

    // 养护操作：修剪
    public Plant prunePlant(Plant plant) {
        plant.setWaterLevel(Math.min(100, plant.getWaterLevel() + 10));
        plant.setLightLevel(Math.min(100, plant.getLightLevel() + 15));
        plant.setNutrientLevel(Math.min(100, plant.getNutrientLevel() + 20));
        return updatePlantGrowthState(plant);
    }

    /**
     * 快进植物时间（仅用于开发测试）
     */
    public Plant advanceTime(Plant plant, int hours) {
        // 获取原始的时间
        LocalDateTime now = LocalDateTime.now();

        // 计算生长天数
        long currentGrowthDays = calculateGrowthDays(plant);

        // 计算要添加的天数
        int daysToAdd = hours / 24;

        // 更新生长天数
        long newGrowthDays = Math.min(14, currentGrowthDays + daysToAdd); // 14天是总周期

        // 更新植物生长阶段
        String newStage = getGrowthStageByDays(newGrowthDays);
        plant.setGrowthStage(newStage);

        // 设置生长开始时间为当前时间减去新的生长天数
        if (plant.getGrowthStartTime() != null) {
            plant.setGrowthStartTime(LocalDateTime.now().minusDays(newGrowthDays));
        }

        // 保存植物
        plant = plantRepository.save(plant);

        // 根据快进的小时数模拟衰减
        int normalDecayTimes = hours / 12; // 每12小时一次正常衰减
        int randomDecayTimes = hours / 24; // 每24小时一次随机衰减

        // 应用正常衰减
        for (int i = 0; i < normalDecayTimes; i++) {
            plant = applyDecay(plant, "normal");
        }

        // 应用随机衰减
        if (randomDecayTimes > 0) {
            String[] decayTypes = { "drought", "pest", "coldwave" };
            Random random = new Random();
            String decayType = decayTypes[random.nextInt(decayTypes.length)];
            plant = applyDecay(plant, decayType);
        }

        // 更新植物生长状态
        return updatePlantGrowthState(plant);
    }
}