package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Review {
    @Id
    @GeneratedValue

    private long id;
    private String title;
    private String reviewBody;

    private String reviewerImgUrl;


    private int starRating;
    @ManyToOne
    private Gym gym;
    @ManyToMany
    private Collection<Hashtag> hashtags;


    public Review( String title, String username, String reviewBody, int starRating, Gym gym, Hashtag... hashtags) {

        this.title = title;
        this.username = username;
        this.reviewBody = reviewBody;
        this.starRating = starRating;
        this.gym = gym;
        this.hashtags = Arrays.asList(hashtags);
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public int getStarRating() {
        return starRating;
    }
}
