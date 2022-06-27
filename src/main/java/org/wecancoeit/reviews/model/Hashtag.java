package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany(mappedBy = "hashtags")
    private Collection<Gym> gyms;

    public Hashtag(String name) {
        this.name = name;
    }

    public Hashtag() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
