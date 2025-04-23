package com.example.mini2.repositories;

import com.example.mini2.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p WHERE p.trip.id = ?1")
    List<Payment> findPaymentsByTripId(Long tripId);

    @Query("SELECT p FROM Payment p WHERE p.amount > ?1")
    List<Payment> findPaymentsAboveAmount(Double amountThreshold);
}
