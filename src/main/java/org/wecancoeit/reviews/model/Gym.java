package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Gym {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String imgUrl;
    private double avgRating;
    @OneToMany(mappedBy = "gym")
    private Collection<Review> reviews;

    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    public Gym(String name, String imgUrl,Category category, Hashtag... hashtags) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.category = category;
        this.hashtags = Arrays.asList(hashtags);
    }

    public Gym() {
    }
    public void updateAvgRating() {
        double sum = 0;
        double avgRatingRaw = 0;
        for (Review review: reviews) {
            sum += review.getRating();
        }
        avgRatingRaw = sum / reviews.size();
        if ((avgRatingRaw*10) % 5 == 0) {
            avgRating =Math.floor((avgRatingRaw*10) / 5) * 5 / 10;
        } else {
            avgRating = (Math.floor(((avgRatingRaw*10) / 5) * 5) + 5) / 10;
        }
    }
    public void addHashtag(Hashtag hashtag) { hashtags.add(hashtag); }
    public void addReview(Review review) { reviews.add(review); }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getImgUrl() { return imgUrl; }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public double getAvgRating() {
        return avgRating;
    }
}
