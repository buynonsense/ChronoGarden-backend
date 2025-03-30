package com.buynonsense.ChronoGarden.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "eras")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Era {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "display_order")
    private Integer displayOrder;

    // 添加额外兼容字段，复用TimeNode的一些信息
    private String period;

    private String climate;

    @Column(name = "environmental_factors")
    private String environmentalFactors;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getEnvironmentalFactors() {
        return environmentalFactors;
    }

    public void setEnvironmentalFactors(String environmentalFactors) {
        this.environmentalFactors = environmentalFactors;
    }
}