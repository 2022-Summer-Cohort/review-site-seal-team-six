package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.GymRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    private HashtagRepository hashtagRepo;
    private GymRepository gymRepo;

    public HashtagController(HashtagRepository hashtagRepo, GymRepository gymRepo) {
        this.hashtagRepo = hashtagRepo;
        this.gymRepo = gymRepo;
    }

    @RequestMapping("/")
    public String getAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "hashtagsTemplate";
    }
    @RequestMapping("/{id}")
    public String getHashtagById(Model model, @PathVariable long id) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "hashtagTemplate";
    }
}
