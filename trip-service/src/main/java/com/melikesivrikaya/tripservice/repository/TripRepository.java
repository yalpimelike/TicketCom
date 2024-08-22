package com.melikesivrikaya.ticketservice.repository;

import com.melikesivrikaya.ticketservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
