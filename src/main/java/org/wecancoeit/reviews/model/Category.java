package org.wecancoeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String categoryImgUrl;
    @OneToMany (mappedBy = "Category")
    private Collection<Gym> gyms;

    public Category(String name, String categoryImgUrl) {
        this.name = name;
        this.categoryImgUrl = categoryImgUrl;
        this.gyms = gyms;
    }

    public Category() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategoryImgUrl() { return categoryImgUrl; }

    public Collection<Gym> getGyms() {
        return gyms;
    }
}
