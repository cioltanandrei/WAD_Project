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
public class Baggage {

    @Id
    @GeneratedValue
    private Long id;
    private BaggageType baggageType;
    //private int count;// number of bags
    private int weight;
    private float price;

    public Baggage(BaggageType baggageType) {
        this.baggageType = baggageType;
        this.weight = BaggageTypeWeight.determineWeight(baggageType).getWeight();
        this.price = BaggageTypePrice.determinePrice(BaggageTypeWeight.determineWeight(baggageType)).getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaggageType getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(BaggageType baggageType) {
        this.baggageType = baggageType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baggage baggage = (Baggage) o;
        return weight == baggage.weight && Float.compare(price, baggage.price) == 0 && baggageType == baggage.baggageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baggageType, weight, price);
    }

    @ManyToOne
    private Ticket ticket;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

}
