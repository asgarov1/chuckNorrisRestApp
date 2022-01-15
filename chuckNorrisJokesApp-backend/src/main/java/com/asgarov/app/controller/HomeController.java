package com.asgarov.app.controller;

import com.asgarov.app.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final JokeService jokeService;

    public HomeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping({"/", "index"})
    public String index(Model model) {
        model.addAttribute("joke", jokeService.getJoke());
        return "index";
    }

}
