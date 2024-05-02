package org.example.xlr8travel.domain;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})

public class Airport {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String iataCode;
    private String description;

    public Airport(String name, String iataCode, String description) {
        this.name = name;
        this.iataCode = iataCode;
        this.description = description;
    }

    public Airport(String name, String iataCode,  City city) {
        this.name = name;
        this.iataCode = iataCode;
        this.city = city;
    }

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

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name) && Objects.equals(iataCode, airport.iataCode) && Objects.equals(description, airport.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, iataCode, description);
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private City city;

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    @OneToMany(mappedBy = "sourceAirport",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Route> sourceRoutes = new HashSet<>();

    public void addSourceRoute(Route route){
        this.getSourceRoutes().add(route);
        route.setSourceAirport(this);
    }

    public void setSourceRoutes(Set<Route> sourceRoutes) {
        this.sourceRoutes = sourceRoutes;
    }

    @OneToMany(mappedBy = "destinationAirport",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Route> destinationRoutes = new HashSet<>();

    public void addDestinationRoute(Route route){
        this.getDestinationRoutes().add(route);
        route.setDestinationAirport(this);
    }

    public void setDestinationRoutes(Set<Route> destinationRoutes) {
        this.destinationRoutes = destinationRoutes;
    }

}
