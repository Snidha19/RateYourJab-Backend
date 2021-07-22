package io.muzoo.ssc.project.backend.whoami;


import io.muzoo.ssc.project.backend.ReviewRepository;
import io.muzoo.ssc.project.backend.UserRepository;
import io.muzoo.ssc.project.backend.model.Review;
import io.muzoo.ssc.project.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
public class ReviewController {

    /*
    - we have to select the data from ReviewRepository
    - Send it to Frontend as ReviewDTO

     */


    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/api/searchbytag")
    public ReviewDTO taggedReviews(HttpServletRequest request){
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null && principal instanceof org.springframework.security.core.userdetails.User) {
                String tag = request.getParameter("tag");
                List<Review> reviews = reviewRepository.findReviewsByTag(tag);
                return ReviewDTO.builder()
                        .reviews(reviews).build();
            }
        } catch (Exception e) {
            //user is not log in
            return ReviewDTO.builder()
                    .build();
        }
        //user is not log in
        return ReviewDTO.builder()
                .build();

    }


    @GetMapping("/api/homepage")
    public ReviewDTO reviews() {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null && principal instanceof org.springframework.security.core.userdetails.User) {
                List<Review> reviews = reviewRepository.findAll();
                return ReviewDTO.builder()
                        .reviews(reviews).build();
            }
        } catch (Exception e) {
            //user is not log in
            return ReviewDTO.builder()
                    .build();
        }
        //user is not log in
        return ReviewDTO.builder()
                .build();

        }



}
