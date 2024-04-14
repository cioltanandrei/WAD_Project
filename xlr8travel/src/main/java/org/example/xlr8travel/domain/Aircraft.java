package org.example.xlr8travel.domain;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})
public class Aircraft {

    @Id
    @GeneratedValue
    private Long id;
    private String name; // name or model of the aircraft
    private String manufacturer;
    private String type;
    private int seatCapacity;
    private int cargoCapacity;
    private String facility; // wifi, food, entertainment, etc
    private String maxTakeoffWeight;
    private int fuelCapacity;
    private double maxFlightRangeKm; // distance in km
    private double maxFlightRangeMiles; // distance in miles

    public Aircraft(String name, String manufacturer, String type, int seatCapacity, int cargoCapacity, String facility, String maxTakeoffWeight, int fuelCapacity, double maxFlightRangeKm, double maxFlightRangeMiles) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.seatCapacity = seatCapacity;
        this.cargoCapacity = cargoCapacity;
        this.facility = facility;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.fuelCapacity = fuelCapacity;
        this.maxFlightRangeKm = maxFlightRangeKm;
        this.maxFlightRangeMiles = maxFlightRangeMiles;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public void setMaxTakeoffWeight(String maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getMaxFlightRangeKm() {
        return maxFlightRangeKm;
    }

    public void setMaxFlightRangeKm(double maxFlightRangeKm) {
        this.maxFlightRangeKm = maxFlightRangeKm;
    }

    public double getMaxFlightRangeMiles() {
        return maxFlightRangeMiles;
    }

    public void setMaxFlightRangeMiles(double maxFlightRangeMiles) {
        this.maxFlightRangeMiles = maxFlightRangeMiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return seatCapacity == aircraft.seatCapacity && cargoCapacity == aircraft.cargoCapacity && fuelCapacity == aircraft.fuelCapacity && Double.compare(maxFlightRangeKm, aircraft.maxFlightRangeKm) == 0 && Double.compare(maxFlightRangeMiles, aircraft.maxFlightRangeMiles) == 0 && Objects.equals(name, aircraft.name) && Objects.equals(manufacturer, aircraft.manufacturer) && Objects.equals(type, aircraft.type) && Objects.equals(facility, aircraft.facility) && Objects.equals(maxTakeoffWeight, aircraft.maxTakeoffWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manufacturer, type, seatCapacity, cargoCapacity, facility, maxTakeoffWeight, fuelCapacity, maxFlightRangeKm, maxFlightRangeMiles);
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
