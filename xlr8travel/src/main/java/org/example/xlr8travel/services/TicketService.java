package org.example.xlr8travel.services;

import org.example.xlr8travel.domain.Ticket;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {

    public void save(Ticket ticket);

    List<Ticket> findAll();

    Ticket findById(Long id);
}
