package com.example.mini2.services;

import com.example.mini2.models.Trip;
import com.example.mini2.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip updateTrip(Long id, Trip trip) {
        Trip existing = tripRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTripDate(trip.getTripDate());
            existing.setOrigin(trip.getOrigin());
            existing.setDestination(trip.getDestination());
            existing.setTripCost(trip.getTripCost());
            existing.setCaptain(trip.getCaptain());
            existing.setCustomer(trip.getCustomer());
            return tripRepository.save(existing);
        }
        return null;
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findTripsByDateRange(startDate, endDate);
    }

    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findTripsByCaptainId(captainId);
    }
}
