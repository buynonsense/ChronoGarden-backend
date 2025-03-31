package com.buynonsense.ChronoGarden.controller;

import com.buynonsense.ChronoGarden.model.Plant;
import com.buynonsense.ChronoGarden.repository.PlantRepository;
import com.buynonsense.ChronoGarden.service.PlantGrowthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantGrowthService plantGrowthService;

    // 获取所有植物
    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plants = plantRepository.findAll();
        return ResponseEntity.ok(plants);
    }

    // 根据ID获取植物
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 获取特定时代的植物
    @GetMapping("/era/{era}")
    public ResponseEntity<List<Plant>> getPlantsByEra(@PathVariable String era) {
        List<Plant> plants = plantRepository.findByEra(era);
        return ResponseEntity.ok(plants);
    }

    // 创建新植物
    @PostMapping
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
        plant.setCreatedAt(LocalDateTime.now());
        plant.setUpdatedAt(LocalDateTime.now());
        Plant savedPlant = plantRepository.save(plant);
        return ResponseEntity.ok(savedPlant);
    }

    // 更新植物信息
    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody Plant plantDetails) {
        return plantRepository.findById(id)
                .map(plant -> {
                    plant.setName(plantDetails.getName());
                    plant.setScientificName(plantDetails.getScientificName());
                    plant.setDescription(plantDetails.getDescription());
                    plant.setCareGuide(plantDetails.getCareGuide());
                    plant.setGrowthStages(plantDetails.getGrowthStages());
                    plant.setWaterNeeds(plantDetails.getWaterNeeds());
                    plant.setLightNeeds(plantDetails.getLightNeeds());
                    plant.setSoilType(plantDetails.getSoilType());
                    plant.setFertilizationNeeds(plantDetails.getFertilizationNeeds());
                    plant.setType(plantDetails.getType());
                    plant.setUpdatedAt(LocalDateTime.now());

                    if (plantDetails.getEra() != null) {
                        plant.setEra(plantDetails.getEra());
                    }

                    Plant updatedPlant = plantRepository.save(plant);
                    return ResponseEntity.ok(updatedPlant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 删除植物
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(plant -> {
                    plantRepository.delete(plant);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 获取植物生长状态
    @GetMapping("/{id}/growth-status")
    public ResponseEntity<Map<String, Object>> getPlantGrowthStatus(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(plant -> {
                    Map<String, Object> status = new HashMap<>();

                    // 计算生长天数
                    long growthDays = plantGrowthService.calculateGrowthDays(plant);

                    // 计算健康状态
                    int healthStatus = plantGrowthService.calculateHealthStatus(plant);

                    status.put("id", plant.getId());
                    status.put("growthDays", growthDays);
                    status.put("totalDays", 14); // 总生长周期
                    status.put("growthStage", plant.getGrowthStage());
                    status.put("waterLevel", plant.getWaterLevel());
                    status.put("lightLevel", plant.getLightLevel());
                    status.put("nutrientLevel", plant.getNutrientLevel());
                    status.put("healthStatus", healthStatus);
                    status.put("healthState", getHealthStateName(healthStatus));
                    status.put("isWithered", plant.getIsWithered());
                    status.put("isCompleted", plant.getIsCompleted());

                    return ResponseEntity.ok(status);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 辅助方法：获取健康状态名称
    private String getHealthStateName(int status) {
        if (status == 0)
            return "withered"; // 枯萎
        if (status <= 30)
            return "endangered"; // 濒危
        if (status <= 79)
            return "normal"; // 正常
        return "healthy"; // 健康
    }

    // 开始植物养护
    @PostMapping("/{id}/start-growth")
    public ResponseEntity<Plant> startPlantGrowth(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(plant -> {
                    Plant updatedPlant = plantGrowthService.startGrowth(plant);
                    return ResponseEntity.ok(updatedPlant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 手动执行衰减（开发模式）
    @PostMapping("/{id}/apply-decay")
    public ResponseEntity<Plant> applyDecay(@PathVariable Long id, @RequestParam String decayType) {
        return plantRepository.findById(id)
                .map(plant -> {
                    Plant updatedPlant = plantGrowthService.applyDecay(plant, decayType);
                    return ResponseEntity.ok(updatedPlant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 养护操作: 浇水
    @PostMapping("/{id}/water")
    public ResponseEntity<?> waterPlant(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(plant -> {
                    if (plant.getIsWithered()) {
                        // 当植物枯萎时，仅返回400 + 空body
                        return ResponseEntity.badRequest().build();
                    }

                    Plant updatedPlant = plantGrowthService.waterPlant(plant);
                    return ResponseEntity.ok(updatedPlant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 养护操作: 调整光照
    @PostMapping("/{id}/light")
    public ResponseEntity<?> adjustLight(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(plant -> {
                    if (plant.getIsWithered()) {
                        return ResponseEntity.badRequest().build();
                    }

                    Plant updatedPlant = plantGrowthService.adjustLight(plant);
                    return ResponseEntity.ok(updatedPlant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 养护操作: 施肥
    @PostMapping("/{id}/fertilize")
    public ResponseEntity<?> fertilizePlant(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(plant -> {
                    if (plant.getIsWithered()) {
                        return ResponseEntity.badRequest().build();
                    }

                    Plant updatedPlant = plantGrowthService.fertilize(plant);
                    return ResponseEntity.ok(updatedPlant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 养护操作: 修剪
    @PostMapping("/{id}/prune")
    public ResponseEntity<?> prunePlant(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(plant -> {
                    if (plant.getIsWithered()) {
                        return ResponseEntity.badRequest().build();
                    }

                    Plant updatedPlant = plantGrowthService.prunePlant(plant);
                    return ResponseEntity.ok(updatedPlant);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}