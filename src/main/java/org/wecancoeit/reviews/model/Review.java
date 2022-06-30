package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String title;
    private String reviewBody;
    private double rating;

    private String reviewerImgUrl = "/images/profile-pic.jpeg";

    @ManyToOne
    private Gym gym;


    public Review(String username, String title, String reviewBody, double rating, Gym gym) {
        this.username = username;
        this.title = title;
        this.reviewBody = reviewBody;
        this.rating = rating;
        this.gym = gym;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }
    public String getUsername() { return username; }

    public String getTitle() {
        return title;
    }


    public String getReviewBody() {
        return reviewBody;
    }

    public String getReviewerImgUrl() {
        return reviewerImgUrl;
    }

    public Gym getGym() {
        return gym;
    }

    public double getRating() {
        return rating;
    }
}
