package org.example.xlr8travel.domain;


import lombok.*;
import jakarta.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})
public class FlightClass {

    @Id
    @GeneratedValue
    private Long id;
    private float fare; // fare for the class which is a price
    private FlightClassType flightClassType; // enum

    public FlightClass(float fare, FlightClassType flightClassType) {
        this.fare = fare;
        this.flightClassType = flightClassType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public FlightClassType getFlightClassType() {
        return flightClassType;
    }

    public void setFlightClassType(FlightClassType flightClassType) {
        this.flightClassType = flightClassType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightClass that = (FlightClass) o;
        return Float.compare(fare, that.fare) == 0 && flightClassType == that.flightClassType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fare, flightClassType);
    }

    @OneToMany(mappedBy = "flightClass", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Ticket> tickets = new HashSet<>();

    public void addTicket(Ticket ticket) {
        this.getTickets().add(ticket);
        ticket.setFlightClass(this);
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }



}
