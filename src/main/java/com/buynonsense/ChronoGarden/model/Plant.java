package com.buynonsense.ChronoGarden.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@Entity
@Table(name = "plants")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String scientificName;
    private String originalName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String era;
    private String firstAppearance;
    private String extinctionTime;
    private String source;

    @Column(columnDefinition = "TEXT")
    private String careGuide;

    @Column(columnDefinition = "TEXT")
    private String growthStages;

    private String waterNeeds;
    private String lightNeeds;
    private String soilType;
    private String fertilizationNeeds;
    private String type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "growth_start_time")
    private LocalDateTime growthStartTime;

    @Column(name = "water_level")
    private Integer waterLevel = 70;

    @Column(name = "light_level")
    private Integer lightLevel = 70;

    @Column(name = "nutrient_level")
    private Integer nutrientLevel = 70;

    @Column(name = "growth_stage")
    private String growthStage = "seed"; // seed, sprout, flower, fruit

    @Column(name = "is_completed")
    private Boolean isCompleted = false;

    @Column(name = "is_withered")
    private Boolean isWithered = false;

    // 衰减上次发生时间
    @Column(name = "last_normal_decay_time")
    private LocalDateTime lastNormalDecayTime;

    @Column(name = "last_random_decay_time")
    private LocalDateTime lastRandomDecayTime;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getExtinctionTime() {
        return extinctionTime;
    }

    public void setExtinctionTime(String extinctionTime) {
        this.extinctionTime = extinctionTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCareGuide() {
        return careGuide;
    }

    public void setCareGuide(String careGuide) {
        this.careGuide = careGuide;
    }

    public String getGrowthStages() {
        return growthStages;
    }

    public void setGrowthStages(String growthStages) {
        this.growthStages = growthStages;
    }

    public String getWaterNeeds() {
        return waterNeeds;
    }

    public void setWaterNeeds(String waterNeeds) {
        this.waterNeeds = waterNeeds;
    }

    public String getLightNeeds() {
        return lightNeeds;
    }

    public void setLightNeeds(String lightNeeds) {
        this.lightNeeds = lightNeeds;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getFertilizationNeeds() {
        return fertilizationNeeds;
    }

    public void setFertilizationNeeds(String fertilizationNeeds) {
        this.fertilizationNeeds = fertilizationNeeds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getGrowthStartTime() {
        return growthStartTime;
    }

    public void setGrowthStartTime(LocalDateTime growthStartTime) {
        this.growthStartTime = growthStartTime;
    }

    public Integer getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Integer waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Integer getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(Integer lightLevel) {
        this.lightLevel = lightLevel;
    }

    public Integer getNutrientLevel() {
        return nutrientLevel;
    }

    public void setNutrientLevel(Integer nutrientLevel) {
        this.nutrientLevel = nutrientLevel;
    }

    public String getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(String growthStage) {
        this.growthStage = growthStage;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Boolean getIsWithered() {
        return isWithered;
    }

    public void setIsWithered(Boolean isWithered) {
        this.isWithered = isWithered;
    }

    public LocalDateTime getLastNormalDecayTime() {
        return lastNormalDecayTime;
    }

    public void setLastNormalDecayTime(LocalDateTime lastNormalDecayTime) {
        this.lastNormalDecayTime = lastNormalDecayTime;
    }

    public LocalDateTime getLastRandomDecayTime() {
        return lastRandomDecayTime;
    }

    public void setLastRandomDecayTime(LocalDateTime lastRandomDecayTime) {
        this.lastRandomDecayTime = lastRandomDecayTime;
    }
}