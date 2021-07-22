package io.muzoo.ssc.project.backend.auth;


import io.muzoo.ssc.project.backend.model.ReviewRepository;
import io.muzoo.ssc.project.backend.dto.SimpleResponseDTO;
import io.muzoo.ssc.project.backend.model.UserRepository;
import io.muzoo.ssc.project.backend.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddReviewController {

    @Autowired
    ReviewRepository reviewRepository;

   @Autowired
   UserRepository userRepository;

    //User will be adding the review
    @PostMapping("api/addreview")
    public SimpleResponseDTO addReview(HttpServletRequest request) {
        //the user can actually add review many times so i dont need to check
        //if the username already existed in the ReviewRepository
        String username = request.getParameter("username");
        String question1 = request.getParameter("question1");
        String question2 = request.getParameter("question2");
        String question3 = request.getParameter("question3");
        String question4 = request.getParameter("question4");
        String question5 = request.getParameter("question5");
        String question6 = request.getParameter("question6");
        String tag = request.getParameter("tag");
        String newReview = request.getParameter("review");
        Integer age = userRepository.findFirstByUsername(request.getRemoteUser()).getAge();
        String gender =userRepository.findFirstByUsername(request.getRemoteUser()).getGender();

        Review review = new Review();
        review.setUsername(username);
        review.setQuestion1(question1);
        review.setQuestion2(question2);
        review.setQuestion3(question3);
        review.setQuestion4(question4);
        review.setQuestion5(question5);
        review.setQuestion6(question6);
        review.setAge(age);
        review.setGender(gender);
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
