package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gyms")
public class GymController {
    private GymRepository gymRepo;
}
