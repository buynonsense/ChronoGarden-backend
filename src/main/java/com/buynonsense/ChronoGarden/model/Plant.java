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

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "original_name")
    private String originalName;

    @Column(columnDefinition = "TEXT")
    private String description;

    // 使用era字段代替TimeNode关联
    private String era;

    @Column(name = "first_appearance")
    private String firstAppearance;

    @Column(name = "extinction_time")
    private String extinctionTime;

    private String source;

    @Column(name = "crawl_time")
    private String crawlTime;

    @Column(name = "source_language")
    private String sourceLanguage;

    @Column(name = "care_needs", columnDefinition = "json")
    private String careNeeds;

    @Column(name = "growth_stages", columnDefinition = "json")
    private String growthStages;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // 为了兼容现有代码，添加这些属性
    private String waterNeeds;
    private String lightNeeds;
    private String soilType;
    private String fertilizationNeeds;
    private String careGuide;

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

    public String getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(String crawlTime) {
        this.crawlTime = crawlTime;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public String getCareNeeds() {
        return careNeeds;
    }

    public void setCareNeeds(String careNeeds) {
        this.careNeeds = careNeeds;
    }

    public String getGrowthStages() {
        return growthStages;
    }

    public void setGrowthStages(String growthStages) {
        this.growthStages = growthStages;
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

    public String getCareGuide() {
        return careGuide;
    }

    public void setCareGuide(String careGuide) {
        this.careGuide = careGuide;
    }
}