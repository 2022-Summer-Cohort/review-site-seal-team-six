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
    @OneToMany (mappedBy = "Category")
    private Collection<Gym> gyms;

    public Category(String name, Collection<Gym> gyms) {
        this.name = name;
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

    public Collection<Gym> getGyms() {
        return gyms;
    }
}
