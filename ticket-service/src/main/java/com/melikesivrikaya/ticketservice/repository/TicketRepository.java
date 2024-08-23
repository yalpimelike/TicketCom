package com.melikesivrikaya.ticketservice.repository;

import com.melikesivrikaya.ticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<List<Ticket>> findByUserIdAndTripId(Long userId, Long tripId);
}
