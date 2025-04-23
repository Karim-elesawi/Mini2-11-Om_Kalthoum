package com.example.mini2.services;

import com.example.mini2.models.Rating;
import com.example.mini2.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }
    public Rating updateRating(String id, Rating updatedRating) {
        Rating existing = ratingRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setScore(updatedRating.getScore());
            existing.setComment(updatedRating.getComment());
            existing.setRatingDate(updatedRating.getRatingDate());
            return ratingRepository.save(existing);
        }
        return null;
    }
    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }
    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }
    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}
