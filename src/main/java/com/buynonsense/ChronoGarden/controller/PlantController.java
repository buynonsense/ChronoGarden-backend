package com.buynonsense.ChronoGarden.controller;

import com.buynonsense.ChronoGarden.model.Plant;
// 删除不需要的导入
// import com.buynonsense.ChronoGarden.model.TimeNode;
import com.buynonsense.ChronoGarden.repository.PlantRepository;
// 删除不需要的导入
// import com.buynonsense.ChronoGarden.repository.TimeNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    // 移除TimeNodeRepository依赖
    // @Autowired
    // private TimeNodeRepository timeNodeRepository;

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
        // 移除TimeNode相关代码
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
                    plant.setUpdatedAt(LocalDateTime.now());

                    // 移除TimeNode相关代码
                    // 只保留era字段更新
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
}