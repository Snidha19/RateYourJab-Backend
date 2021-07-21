package io.muzoo.ssc.project.backend.auth;


import io.muzoo.ssc.project.backend.ReviewRepository;
import io.muzoo.ssc.project.backend.SimpleResponseDTO;
import io.muzoo.ssc.project.backend.UserRepository;
import io.muzoo.ssc.project.backend.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddReviewController {

    //store review in the database
    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewRepository reviewRepository;

    //User will be adding the review
    @PostMapping("api/addreview")
    public SimpleResponseDTO addReview(HttpServletRequest request) {
        //the user can actually add review many times so i dont need to check
        //if the username already existed in the ReviewRepository
        String username = request.getParameter("username");
        int question1 = Integer.parseInt(request.getParameter("question1"));
        int question2 = Integer.parseInt(request.getParameter("question2"));
        int question3 = Integer.parseInt(request.getParameter("question3"));
        int question4 = Integer.parseInt(request.getParameter("question4"));
        int question5 = Integer.parseInt(request.getParameter("question5"));
        int question6 = Integer.parseInt(request.getParameter("question6"));
        String tag = request.getParameter("tag");
        String newReview = request.getParameter("review");

        Review review = new Review();
        review.setUsername(username);
        review.setQuestion1(question1);
        review.setQuestion1(question2);
        review.setQuestion1(question3);
        review.setQuestion1(question4);
        review.setQuestion1(question5);
        review.setQuestion1(question6);
        review.setTag(tag);
        review.setReview(newReview);
        reviewRepository.save(review);

        return SimpleResponseDTO
                .builder()
                .success(true)
                .message("Review added")
                .build();

    }


}
