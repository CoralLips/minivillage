package com.yida.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "building")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private int building_id;

    private int buildingNumber;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;
}
