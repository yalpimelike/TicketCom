package com.melikesivrikaya.tripservice.repository;

import com.melikesivrikaya.tripservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
