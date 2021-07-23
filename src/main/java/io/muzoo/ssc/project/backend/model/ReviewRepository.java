package io.muzoo.ssc.project.backend.model;

import io.muzoo.ssc.project.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByTag(String tag);
    List<Review> findAll();
}

