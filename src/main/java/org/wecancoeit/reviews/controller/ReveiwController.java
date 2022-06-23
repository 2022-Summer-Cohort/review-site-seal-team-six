package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.repos.GymRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

@Controller
@RequestMapping("/reviews")
public class ReveiwController {
    private ReviewRepository reviewRepo;
    private GymRepository gymRepo;

    public ReveiwController(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }
    @RequestMapping("/gym/{gymName}")
    public String showReview(Model model, @PathVariable String gymName){
        model.addAttribute("review", reviewRepo.findByGymIgnoreCase(gymName).get());
        return "review";
    }
}
