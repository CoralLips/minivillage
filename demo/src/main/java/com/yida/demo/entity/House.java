package com.yida.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "house")
@JsonIgnoreProperties(ignoreUnknown = true)
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private int house_id;

    private int houseNumber;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
