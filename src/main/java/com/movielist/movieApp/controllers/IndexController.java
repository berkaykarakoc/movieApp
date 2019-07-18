package com.movielist.movieApp.controllers;

import com.movielist.movieApp.services.MovieListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private MovieListService movieListService;

    public IndexController(MovieListService movieListService) {
        this.movieListService = movieListService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("movieLists", movieListService.getMovieLists());
        return "index";
    }

}
