package org.example.xlr8travel.repositories;

import org.example.xlr8travel.domain.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository  extends CrudRepository<Flight, Long> {

    // Flight findByFlightNumber(String flightNumber);

    List<Flight> findAll();
}
