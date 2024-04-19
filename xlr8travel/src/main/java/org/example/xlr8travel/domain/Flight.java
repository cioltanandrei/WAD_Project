package org.example.xlr8travel.domain;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})

public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private String terminal;
    private String gate;
    private LocalDateTime lastUpdated; // last updated time

    public Flight(String name, LocalTime departureTime, LocalTime arrivalTime, String terminal, String gate, LocalDateTime lastUpdated) {
        this.name = name;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.terminal = terminal;
        this.gate = gate;
        this.lastUpdated = lastUpdated;
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

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(name, flight.name) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(arrivalTime, flight.arrivalTime) && Objects.equals(terminal, flight.terminal) && Objects.equals(gate, flight.gate) && Objects.equals(lastUpdated, flight.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, departureTime, arrivalTime, terminal, gate, lastUpdated);
    }

    @ManyToOne
    private Airline airline;

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airline getAirline() {
        return airline;
    }

    @OneToMany(mappedBy = "flight",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Ticket> tickets = new HashSet<>();

    public void addTicket(Ticket ticket){
        this.getTickets().add(ticket);
        ticket.setFlight(this);
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }


}
