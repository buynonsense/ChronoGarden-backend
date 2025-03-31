package com.buynonsense.ChronoGarden.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "care_record")
public class CareRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @Column(name = "action_type")
    private String actionType; // 浇水、施肥、提供阳光等

    private String notes;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "water_level")
    private Integer waterLevel;

    @Column(name = "nutrient_level")
    private Integer nutrientLevel;

    @Column(name = "health_status")
    private Integer healthStatus;

    @Column(name = "growth_stage")
    private Integer growthStage;

    // 构造函数、getter和setter
    public CareRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Integer getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Integer waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Integer getNutrientLevel() {
        return nutrientLevel;
    }

    public void setNutrientLevel(Integer nutrientLevel) {
        this.nutrientLevel = nutrientLevel;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Integer getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(Integer growthStage) {
        this.growthStage = growthStage;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.timestamp = createdTime;
    }

    public LocalDateTime getCreatedTime() {
        return this.timestamp;
    }
}