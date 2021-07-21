package io.muzoo.ssc.project.backend;

import io.muzoo.ssc.project.backend.model.Review;
import io.muzoo.ssc.project.backend.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    List<Review> findAll();

    //different tag
    List<Review> findAll(Sort sort);
}