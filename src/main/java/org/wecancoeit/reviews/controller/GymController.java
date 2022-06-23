package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.GymRepository;

@Controller
@RequestMapping("/gyms")
public class GymController {
    private GymRepository gymRepo;

    public GymController(GymRepository gymRepo) {
        this.gymRepo = gymRepo;
    }
    @RequestMapping("/{id}")
    public String showGym(Model model, @PathVariable Long id) {
        model.attribute("b",)
    }
}
