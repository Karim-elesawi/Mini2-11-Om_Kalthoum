package com.example.mini2.repositories;

import com.example.mini2.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    @Query("SELECT c FROM Captain c WHERE c.avgRatingScore > ?1")
    List<Captain> findCaptainsByRatingAbove(Double ratingThreshold);

    Optional<Captain> findByLicenseNumber(String licenseNumber);
}
