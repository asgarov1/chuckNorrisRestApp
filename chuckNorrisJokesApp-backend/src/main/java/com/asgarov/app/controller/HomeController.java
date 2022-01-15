package com.asgarov.app.controller;

import com.asgarov.app.service.JokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final JokeService jokeService;

    public HomeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping(value = "/randomJoke", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> index() {
        return ResponseEntity.ok(jokeService.getJoke());
    }

}
