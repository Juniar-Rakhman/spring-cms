package com.rcs.spring.cms.domain.entities;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author claudioed on 29/10/17. Project cms
 */
public class NewsTest {

    @Test
    public void shouldBeRevised() {
        News news = new News();
        User reviewer = new User();
        reviewer.setId("1010");
        news.setMandatoryReviewers(Stream.of(reviewer).collect(Collectors.toSet()));
        news.review("1010", "approved");
        assertTrue(news.revised());
    }

    @Test
    public void wrongUserReviewedAndShouldBeNotRevised() {
        News news = new News();
        User reviewer = new User();
        reviewer.setId("2020");
        news.setMandatoryReviewers(Stream.of(reviewer).collect(Collectors.toSet()));
        news.review("1010", "approved");
        assertFalse(news.revised());
    }

    @Test
    public void userNotApprovedAndShouldBeNotRevised() {
        News news = new News();
        User reviewer = new User();
        reviewer.setId("1010");
        news.setMandatoryReviewers(Stream.of(reviewer).collect(Collectors.toSet()));
        news.review("1010", "unapproved");
        assertFalse(news.revised());
    }

}
