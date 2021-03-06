package io.muzoo.ssc.project.backend.auth;


import io.muzoo.ssc.project.backend.model.ReviewRepository;
import io.muzoo.ssc.project.backend.model.Review;
import io.muzoo.ssc.project.backend.dto.ReviewDTO;
import io.muzoo.ssc.project.backend.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/searchbytag")
    public ReviewDTO taggedReviews(HttpServletRequest request){
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null && principal instanceof org.springframework.security.core.userdetails.User) {
                String tag = request.getParameter("tag");
                List<Review> reviews = reviewRepository.findReviewsByTag(tag);
                // list<>
                return ReviewDTO.builder()
                        .loggedIn(true)
                        .reviews(reviews).build();
            }
        } catch (Exception e) {
            return ReviewDTO.builder()
                    .loggedIn(false)
                    .build();
        }
        //user is not log in
        return ReviewDTO.builder()
                .loggedIn(false)
                .build();

    }


    @GetMapping("/api/review")
    public ReviewDTO reviews() {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null && principal instanceof org.springframework.security.core.userdetails.User) {
                List<Review> reviews = reviewRepository.findAll();
                return ReviewDTO.builder()
                        .loggedIn(true)
                        .reviews(reviews).build();
            }
        } catch (Exception e) {
            //user is not log in
            return ReviewDTO.builder()
                    .loggedIn(false)
                    .build();
        }
        //user is not log in
        return ReviewDTO.builder()
                .loggedIn(false)
                .build();
    }
}