package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Gym {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String imgUrl;
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
}
