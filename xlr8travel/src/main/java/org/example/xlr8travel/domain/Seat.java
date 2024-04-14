package org.example.xlr8travel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {})
public class Seat {

    @Id
    @GeneratedValue
    private Long id;
    private String seatNumber;
    private boolean isBooked;
    private SeatType seatType; // for comfort not class
    private SeatPrice seatPrice; // for price

    public Seat(String seatNumber, boolean isBooked, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
        this.seatType = seatType;
        this.seatPrice = SeatPrice.getPriceByType(seatType);  // Correctly determine price from type
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
        this.seatPrice = SeatPrice.getPriceByType(seatType);  // Correctly determine price from type
    }

    public SeatPrice getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(SeatPrice seatPrice) {
        this.seatPrice = seatPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return isBooked == seat.isBooked && seatNumber.equals(seat.seatNumber) && seatType == seat.seatType && seatPrice == seat.seatPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, isBooked, seatType, seatPrice);
    }


}
