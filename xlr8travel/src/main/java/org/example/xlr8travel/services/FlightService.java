package org.example.xlr8travel.services;

import org.example.xlr8travel.domain.Flight;

import java.util.List;

public interface FlightService {

    public void save(Flight flight);

    List<Flight> findAll();

    Flight findById(Long id);
}
