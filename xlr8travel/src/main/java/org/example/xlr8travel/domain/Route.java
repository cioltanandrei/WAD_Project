package org.example.xlr8travel.domain;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})
public class Route {

    @Id
    @GeneratedValue
    private Long id;
    private int distance;// in km
    private LocalTime duration; // in hours and minutes

    public Route(int distance, LocalTime duration) {
        this.distance = distance;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return distance == route.distance && Objects.equals(duration, route.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, duration);
    }

    @ManyToOne
    private Airport sourceAirport;

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public Airport getSourceAirport() {
        return sourceAirport;
    }

    @ManyToOne
    private Airport destinationAirport;

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    @ManyToOne
    private Airline airline;

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airline getAirline() {
        return airline;
    }
}
