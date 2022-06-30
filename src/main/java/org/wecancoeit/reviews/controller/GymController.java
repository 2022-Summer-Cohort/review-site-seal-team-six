package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancoeit.reviews.model.Gym;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.repos.GymRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

import java.util.Optional;

@Controller
@RequestMapping("/gyms")
public class GymController {
    private GymRepository gymRepo;
    private ReviewRepository reviewRepo;
    private HashtagRepository hashtagRepo;

    public GymController(GymRepository gymRepo, ReviewRepository reviewRepo, HashtagRepository hashtagRepo) {
        this.gymRepo = gymRepo;
        this.reviewRepo = reviewRepo;
        this.hashtagRepo = hashtagRepo;

    }

    @RequestMapping("/")
    public String showGyms(Model model) {
        model.addAttribute("gyms", gymRepo.findAll());
        return "hashtagTemplate";
    }
    @RequestMapping("/{id}")
    public String showGym(Model model, @PathVariable Long id) {
        model.addAttribute("gym", gymRepo.findById(id).get());
        return "reviewListTemplate";
    }
    @PostMapping("/{id}/addReview")
    public String addReviewToGym(@PathVariable Long id, @RequestParam String hashtag, @RequestParam String userName,
                                 @RequestParam Double rating, @RequestParam String title, @RequestParam String reviewBody){
        Gym gym = gymRepo.findById(id).get();
        Review review = new Review(userName, title, reviewBody, rating, gym);
        reviewRepo.save(review);
        gym.updateAvgRating();

        Optional<Hashtag> hashtagOptional = hashtagRepo.findByNameIgnoreCase(hashtag);
        if(hashtagOptional.isPresent()){
            if(!gym.getHashtags().contains(hashtagOptional.get())){
                gym.addHashtag(hashtagOptional.get());
            }
        }
        else {
            Hashtag hashtag1 = new Hashtag(hashtag);
            hashtagRepo.save(hashtag1);
            gym.addHashtag(hashtag1);
        }
        gymRepo.save(gym);

        return "redirect:/gyms/"+id;
    }


    }
