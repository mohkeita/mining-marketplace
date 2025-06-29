package io.mohkeita.mining_marketplace.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicles")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Vehicle extends BaseEntity {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(nullable = false)
    private String plateNumber;

    @Column(nullable = false)
    private String type;

    private String model;
    private double dailyRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    @ToString.Exclude
    private User owner;

    private boolean available = true;

    private double payloadKg;
    private double emptyWeightKg;
    private double grossWeightKg;
    private String engine;
    private int powerHp;
    private int topSpeedKph;
    private String brakingSpecs;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private FuelType fuelType;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<VehicleImage> images = new HashSet<>();

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Review> reviews = new HashSet<>();
}