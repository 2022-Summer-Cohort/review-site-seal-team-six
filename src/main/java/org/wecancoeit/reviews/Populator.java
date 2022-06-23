package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
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
    Review review1 = new Review("Smells Bad","blaaablaaaaablaaaaaaaaaaaaaaaaaaaaa",3,"Boxing Nearby");
    reviewRepo.save(review1);
    }
}
