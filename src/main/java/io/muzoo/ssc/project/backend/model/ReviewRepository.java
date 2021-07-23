package io.muzoo.ssc.project.backend.model;

import io.muzoo.ssc.project.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

//    @Query( value = "select r.username, r.tag, r.review from  tbl_review r",
//            nativeQuery = true)
    List<Review> findReviewsByTag(String tag);

    List<Review> findAll();
    Review findReviewByUsername(String username);


}
