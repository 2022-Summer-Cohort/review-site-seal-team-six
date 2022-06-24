package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Gym;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.repos.ReviewRepository;

@Component
public class Populator implements CommandLineRunner {
    private ReviewRepository reviewRepo;

    public Populator(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Gym gracyBJJ = new Gym("Gracy BJJ","45232", "/images/BJJ.jpg");
        Review review1 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.","/images/profile-pic.jpeg", 2, gracyBJJ);
        reviewRepo.save(review1);
    }
}
