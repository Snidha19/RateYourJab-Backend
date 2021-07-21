package io.muzoo.ssc.project.backend.whoami;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.muzoo.ssc.project.backend.model.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReviewDTO {
    List<Review> reviews;
    List<Review> taggedReviews;

}
