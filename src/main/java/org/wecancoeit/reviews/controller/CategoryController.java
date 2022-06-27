package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.CategoryRepository;
import org.wecancoeit.reviews.repos.GymRepository;

import javax.persistence.Entity;

@Controller
public class CategoryController {
    private CategoryRepository categoryRepo;
    private GymRepository gymRepo;

    public CategoryController(CategoryRepository categoryRepo, GymRepository gymRepo) {
        this.categoryRepo = categoryRepo;
        this.gymRepo = gymRepo;
    }

    @RequestMapping("/")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "categoriesTemplate";
    }
    @RequestMapping("categories/{id}")
    public String showCategory(Model model, @PathVariable long id) {
        model.addAttribute("category", categoryRepo.findById(id).get());
        return "categoryTemplate";
    }
}
