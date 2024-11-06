package org.example.xlr8travel.models;

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
@Getter
@Setter

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

    @OneToMany(mappedBy = "flight",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Ticket> tickets = new HashSet<>();

    public void addTicket(Ticket ticket){
        this.getTickets().add(ticket);
        ticket.setFlight(this);
    }



}
