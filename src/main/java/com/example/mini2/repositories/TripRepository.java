package com.example.mini2.repositories;

import com.example.mini2.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("SELECT t FROM Trip t WHERE t.tripDate BETWEEN ?1 AND ?2")
    List<Trip> findTripsByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT t FROM Trip t WHERE t.captain.id = ?1")
    List<Trip> findTripsByCaptainId(Long captainId);
}
