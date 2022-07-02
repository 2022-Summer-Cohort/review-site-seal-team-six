package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.*;
import org.wecancoeit.reviews.repos.*;

@Component
public class Populator implements CommandLineRunner {
    private ReviewRepository reviewRepo;
    private GymRepository gymRepo;
    private CategoryRepository categoryRepo;
    private HashtagRepository hashtagRepo;



    public Populator(ReviewRepository reviewRepo, GymRepository gymRepo, CategoryRepository categoryRepo, HashtagRepository hashtagRepo) {
        this.reviewRepo = reviewRepo;
        this.gymRepo = gymRepo;
        this.categoryRepo = categoryRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Category taekwondo = new Category("Taekwondo", "/images/TaeKwondo.jpg");
        Category kungFu = new Category("Kung Fu", "/images/newkungfu.jpg");
        Category bJJ = new Category("BJJ", "/images/bjj2.jpg");
        Category boxing = new Category("Boxing", "/images/Boxing.jpg");
        categoryRepo.save(taekwondo);
        categoryRepo.save(kungFu);
        categoryRepo.save(bJJ);
        categoryRepo.save(boxing);
        Hashtag hTTaekwondo = new Hashtag("#taekwondo");
        Hashtag hTKungFu = new Hashtag("#kungfu");
        Hashtag hTBJJ = new Hashtag("#bjj");
        Hashtag hTBoxing = new Hashtag("#boxing");
        hashtagRepo.save(hTTaekwondo);
        hashtagRepo.save(hTKungFu);
        hashtagRepo.save(hTBJJ);
        hashtagRepo.save(hTBoxing);
        Gym chaeTaeK = new Gym("Chae's Taekwondo", "/images/TaeKwondo.jpg", taekwondo, hTTaekwondo );
        Gym billBox = new Gym("Bill's Boxing", "/images/Boxing.jpg", boxing, hTBoxing);
        Gym chaoKF = new Gym("Chao Kung Fu","/images/newkungfu.jpg", kungFu, hTKungFu);
        Gym gracyBJJ = new Gym("Gracy BJJ", "/images/bjj2.jpg",bJJ, hTBJJ);
        gymRepo.save(chaeTaeK);
        gymRepo.save(billBox);
        gymRepo.save(chaoKF);
        gymRepo.save(gracyBJJ);
        Review review1 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.", 4, gracyBJJ);
        Review review2 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.", 5, chaoKF);
        Review review3 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.", 3.5, billBox);
        Review review4 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.", 2.5, chaeTaeK);
        reviewRepo.save(review1);
        reviewRepo.save(review2);
        reviewRepo.save(review3);
        reviewRepo.save(review4);
    }
}
