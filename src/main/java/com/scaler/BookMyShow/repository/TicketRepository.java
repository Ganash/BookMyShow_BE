package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    //optional means object can be created or cannot be created
    @Override
    Optional<Ticket> findById(Long ticketId);

    Ticket save(Ticket ticket);
}
