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
    private String zipCode;
    @OneToMany(mappedBy = "gym")
    private Collection<Review> reviews;

    @ManyToOne
    private Category category;
    @ManyToOne
    private Hashtag hashtag;

    public Gym(long id, String name,String zipCode) {
        this.id = id;
        this.name = name;

    }

    public Gym() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
