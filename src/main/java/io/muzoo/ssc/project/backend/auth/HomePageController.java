package io.muzoo.ssc.project.backend.auth;

import io.muzoo.ssc.project.backend.ReviewRepository;
import io.muzoo.ssc.project.backend.model.Review;
import io.muzoo.ssc.project.backend.whoami.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HomePageController {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReviewDTO reviews;
    @GetMapping("/api/homepage")
    //this will be directed only if a user is logged in
    //once the user is here, all the reviews will be rendered
    public ReviewDTO home(){
        reviews.getReviews();
        return reviews;
    }



    public ReviewDTO searchByTag(HttpServletRequest servletRequest){
        reviews.getTaggedReviews();
        return reviews;
    }
}
