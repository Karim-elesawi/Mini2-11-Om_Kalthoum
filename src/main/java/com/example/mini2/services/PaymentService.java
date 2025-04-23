package com.example.mini2.services;

import com.example.mini2.models.Payment;
import com.example.mini2.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
    public Payment updatePayment(Long id, Payment payment) {
        Payment existing = paymentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setAmount(payment.getAmount());
            existing.setPaymentMethod(payment.getPaymentMethod());
            existing.setPaymentStatus(payment.getPaymentStatus());
            existing.setTrip(payment.getTrip());
            return paymentRepository.save(existing);
        }
        return null;
    }
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
    public List<Payment> findPaymentsByTripId(Long tripId) {
        return paymentRepository.findPaymentsByTripId(tripId);
    }
    public List<Payment> findByAmountThreshold(Double threshold) {
        return paymentRepository.findPaymentsAboveAmount(threshold);
    }
}
