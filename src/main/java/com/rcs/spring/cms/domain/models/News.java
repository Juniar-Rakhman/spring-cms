package com.rcs.spring.cms.domain.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.thymeleaf.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author claudioed on 28/10/17. Project cms
 */
@Data
@Document(collection = "news")
public class News {

    String id;
    String title;
    String content;
    User author;

    Set<User> mandatoryReviewers = new HashSet<>();
    Set<Review> reviews = new HashSet<>();
    Set<Category> categories = new HashSet<>();
    Set<Tag> tags = new HashSet<>();

    public Boolean revised() {
        return this.mandatoryReviewers.stream().allMatch(reviewer -> this.reviews.stream()
            .anyMatch(review -> StringUtils.equals(reviewer.id, review.userId) && StringUtils.equals(review.status, "approved")));
    }

    public Review review(String userId, String status) {
        final Review review = new Review(userId, status);
        this.reviews.add(review);
        return review;
    }

}