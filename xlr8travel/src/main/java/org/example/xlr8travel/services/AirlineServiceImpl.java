package org.example.xlr8travel.services;

import org.example.xlr8travel.domain.Airline;
import org.example.xlr8travel.repositories.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirlineServiceImpl implements AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public void save(Airline airline) {
        airlineRepository.save(airline);
    }

    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }
}
