package com.buynonsense.ChronoGarden.model;

import jakarta.persistence.*;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String careGuide;

    @ManyToOne
    @JoinColumn(name = "time_node_id")
    private TimeNode timeNode;

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

    public String getCareGuide() {
        return careGuide;
    }

    public void setCareGuide(String careGuide) {
        this.careGuide = careGuide;
    }

    public TimeNode getTimeNode() {
        return timeNode;
    }

    public void setTimeNode(TimeNode timeNode) {
        this.timeNode = timeNode;
    }
}