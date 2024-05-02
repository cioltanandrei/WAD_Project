package org.example.xlr8travel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;
    private float price; // price of the ticket all in all
    private LocalDateTime purchaseTime;
    private TicketStatus ticketStatus;


    public Ticket(float price, LocalDateTime purchaseTime, TicketStatus ticketStatus, Seat seat) {
        this.price = price;
        this.purchaseTime = purchaseTime;
        this.ticketStatus = ticketStatus;
        this.seat = seat;
    }

    public Ticket(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Float.compare(price, ticket.price) == 0 && Objects.equals(purchaseTime, ticket.purchaseTime) && ticketStatus == ticket.ticketStatus && Objects.equals(seat, ticket.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, purchaseTime, ticketStatus, seat);
    }

    @ManyToOne
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @ManyToOne
    private Flight flight;

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    private Seat seat;


    @OneToMany(mappedBy = "ticket", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Baggage> baggages = new HashSet<>();

    public void addBaggage(Baggage baggage){
        this.getBaggages().add(baggage);
        baggage.setTicket(this);
    }

    public void setBaggages(Set<Baggage> baggages) {
        this.baggages = baggages;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private FlightClass flightClass;

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

}
