package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.GymRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

@Controller
@RequestMapping("/gyms")
public class GymController {
    private GymRepository gymRepo;
    private ReviewRepository reviewRepo;


    public GymController(GymRepository gymRepo, ReviewRepository reviewRepo) {
        this.gymRepo = gymRepo;
        this.reviewRepo = reviewRepo;
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
    }
