package org.example.xlr8travel.services;

import org.example.xlr8travel.models.Flight;
import org.example.xlr8travel.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findById(Long id) {
        return flightRepository.findById(id).orElse(null);

    }
}