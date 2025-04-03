package com.buynonsense.ChronoGarden.controller;

import com.buynonsense.ChronoGarden.model.Plant;
import com.buynonsense.ChronoGarden.repository.PlantRepository;
import com.buynonsense.ChronoGarden.service.PlantGrowthService;
import com.buynonsense.ChronoGarden.model.User;
import com.buynonsense.ChronoGarden.repository.UserRepository;
import com.buynonsense.ChronoGarden.model.CareRecord;
import com.buynonsense.ChronoGarden.repository.CareRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantGrowthService plantGrowthService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CareRecordRepository careRecordRepository;

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
                    if (plant.getIsWithered() || plant.getIsCompleted()) {
                        return ResponseEntity.badRequest().build();
                    }

                    // 调试日志：记录调整前的光照值
                    System.out.println("调整前光照值: " + plant.getLightLevel());

                    // 调用服务处理阳光操作
                    Plant updatedPlant = plantGrowthService.adjustLight(plant);

                    // 调试日志：记录调整后的光照值
                    System.out.println("调整后光照值: " + updatedPlant.getLightLevel());

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

    // 获取用户已领养的植物
    @GetMapping("/user/adopted")
    public ResponseEntity<List<Plant>> getUserAdoptedPlants() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();

            // 获取当前用户
            User user = userRepository.findByUsername(username);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            // 获取用户已领养的植物
            List<Plant> adoptedPlants = plantRepository.findByAdoptedByUserId(user.getId());
            return ResponseEntity.ok(adoptedPlants);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 领养植物
    @PostMapping("/{id}/adopt")
    public ResponseEntity<Plant> adoptPlant(@PathVariable Long id) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();

            // 获取当前用户
            User user = userRepository.findByUsername(username);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).<Plant>build();
            }

            return plantRepository.findById(id)
                    .map(plant -> {
                        // 如果植物已经被领养，返回错误
                        if (plant.getAdoptedByUserId() != null) {
                            return ResponseEntity.status(HttpStatus.CONFLICT)
                                    .<Plant>build(); // 显式指定类型为 Plant
                        }

                        // 将植物与用户关联，设置初始值并启动生长
                        plant.setAdoptedByUserId(user.getId());
                        plant = plantGrowthService.startGrowth(plant);

                        return ResponseEntity.ok(plant);
                    })
                    .orElse(ResponseEntity.notFound().<Plant>build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).<Plant>build();
        }
    }

    /**
     * 收获植物
     */
    @PostMapping("/{id}/harvest")
    public ResponseEntity<Plant> harvestPlant(@PathVariable Long id) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();

            // 获取当前用户
            User user = userRepository.findByUsername(username);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).<Plant>build();
            }

            return plantRepository.findById(id)
                    .map(plant -> {
                        // 验证植物归属
                        if (!user.getId().equals(plant.getAdoptedByUserId())) {
                            return ResponseEntity.status(HttpStatus.FORBIDDEN).<Plant>build();
                        }

                        // 验证是否处于结果期
                        if (!"fruit".equals(plant.getGrowthStage())) {
                            return ResponseEntity.status(HttpStatus.BAD_REQUEST).<Plant>build();
                        }

                        // 设置为已完成状态
                        plant.setIsCompleted(true);
                        plant = plantRepository.save(plant);

                        return ResponseEntity.ok(plant);
                    })
                    .orElse(ResponseEntity.notFound().<Plant>build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).<Plant>build();
        }
    }

    @PostMapping("/{id}/advance-time")
    public ResponseEntity<Plant> advanceTime(@PathVariable Long id, @RequestParam int hours) {
        // 移除环境检查，允许在任何环境使用
        // 注意：这可能会在生产环境中造成安全风险

        try {
            Plant plant = plantRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("植物不存在"));

            // 快进植物时间
            plant = plantGrowthService.advanceTime(plant, hours);

            return ResponseEntity.ok(plant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).<Plant>build();
        }
    }

    /**
     * 获取用户需要关注的植物（水分/光照/养分任一低于30的植物）
     */
    @GetMapping("/user/needing-care")
    public ResponseEntity<List<Map<String, Object>>> getPlantsNeedingCare() {

        // 添加调试日志查看方法是否被调用
        System.out.println("访问了 getPlantsNeedingCare 方法");

        try {
            // 获取当前登录用户
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            User user = userRepository.findByUsername(username);

            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            // 获取用户所有植物
            List<Plant> userPlants = plantRepository.findByAdoptedByUserId(user.getId());
            List<Map<String, Object>> plantsNeedingCare = new ArrayList<>();

            // 遍历所有植物，找出需要关注的植物
            for (Plant plant : userPlants) {
                // 仅处理未完成且未枯萎的植物
                if (!plant.getIsCompleted() && !plant.getIsWithered()) {
                    // 检查水分、光照、养分是否低于30
                    if (plant.getWaterLevel() < 30 || plant.getLightLevel() < 30 || plant.getNutrientLevel() < 30) {
                        Map<String, Object> plantInfo = new HashMap<>();

                        // 基本信息
                        plantInfo.put("id", plant.getId());
                        plantInfo.put("name", plant.getName());

                        // 确定需要关注的原因
                        List<String> reasons = new ArrayList<>();
                        if (plant.getWaterLevel() < 30)
                            reasons.add("缺水");
                        if (plant.getLightLevel() < 30)
                            reasons.add("缺光");
                        if (plant.getNutrientLevel() < 30)
                            reasons.add("缺肥");

                        plantInfo.put("status", String.join("/", reasons));

                        // 获取最后养护时间
                        List<CareRecord> records = careRecordRepository.findByPlantIdOrderByTimestampDesc(plant.getId(),
                                PageRequest.of(0, 1));

                        if (!records.isEmpty()) {
                            plantInfo.put("lastCareDate", records.get(0).getTimestamp());
                        } else {
                            plantInfo.put("lastCareDate", null);
                        }

                        plantsNeedingCare.add(plantInfo);
                    }
                }
            }

            return ResponseEntity.ok(plantsNeedingCare);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/status-history")
    public ResponseEntity<List<Map<String, Object>>> getPlantStatusHistory(@PathVariable Long id) {
        return plantRepository.findById(id)
                .map(plant -> {
                    List<Map<String, Object>> history = new ArrayList<>();

                    // 当前状态作为第一个数据点
                    Map<String, Object> current = new HashMap<>();
                    current.put("timestamp", LocalDateTime.now());
                    current.put("waterLevel", plant.getWaterLevel());
                    current.put("lightLevel", plant.getLightLevel());
                    current.put("nutrientLevel", plant.getNutrientLevel());
                    current.put("growthStage", plant.getGrowthStage());
                    history.add(current);

                    // 获取养护记录，用于生成历史数据点
                    List<CareRecord> records = careRecordRepository.findByPlantIdOrderByTimestampDesc(
                            plant.getId(), PageRequest.of(0, 10));

                    // 简化：为每个记录创建一个历史数据点
                    for (CareRecord record : records) {
                        Map<String, Object> point = new HashMap<>();
                        point.put("timestamp", record.getTimestamp());

                        // 根据操作类型推算历史状态值
                        int waterLevel = plant.getWaterLevel();
                        int lightLevel = plant.getLightLevel();
                        int nutrientLevel = plant.getNutrientLevel();

                        // 根据记录类型模拟历史值
                        switch (record.getActionType()) {
                            case "浇水":
                                waterLevel = Math.max(0, waterLevel - 30);
                                break;
                            case "阳光":
                                lightLevel = Math.max(0, lightLevel - 30);
                                break;
                            case "施肥":
                                nutrientLevel = Math.max(0, nutrientLevel - 30);
                                break;
                            case "修剪":
                                waterLevel = Math.max(0, waterLevel - 10);
                                lightLevel = Math.max(0, lightLevel - 15);
                                nutrientLevel = Math.max(0, nutrientLevel - 20);
                                break;
                        }

                        point.put("waterLevel", waterLevel);
                        point.put("lightLevel", lightLevel);
                        point.put("nutrientLevel", nutrientLevel);
                        point.put("growthStage", plant.getGrowthStage());

                        history.add(point);
                    }

                    // 添加初始点
                    if (plant.getGrowthStartTime() != null) {
                        Map<String, Object> initial = new HashMap<>();
                        initial.put("timestamp", plant.getGrowthStartTime());
                        initial.put("waterLevel", 70);
                        initial.put("lightLevel", 70);
                        initial.put("nutrientLevel", 70);
                        initial.put("growthStage", "seed");
                        history.add(initial);
                    }

                    // 按时间排序
                    Collections.sort(history, (a, b) -> ((LocalDateTime) a.get("timestamp"))
                            .compareTo((LocalDateTime) b.get("timestamp")));

                    return ResponseEntity.ok(history);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}