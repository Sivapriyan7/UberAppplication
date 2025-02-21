package com.codingshuttle.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(name = "idx_driver_vehicle_id", columnList = "vehicleId")
})
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;

    private Boolean available;


    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", unique = true)
    private Vehicle vehicle;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    Point currentLocation;
}
