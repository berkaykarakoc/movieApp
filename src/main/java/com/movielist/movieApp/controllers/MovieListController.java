package com.movielist.movieApp.controllers;

import com.movielist.movieApp.models.MovieList;
import com.movielist.movieApp.services.MovieListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieListController {

    private MovieListService movieListService;

    public MovieListController(MovieListService movieListService) {
        this.movieListService = movieListService;
    }

    @GetMapping("/movieList/{id}/show")
    public String showMovieList(@PathVariable String id, Model model) {
        model.addAttribute("movieList", movieListService.findById(Long.valueOf(id)));
        return "movie_list/show";
    }

    @GetMapping("movieList/new")
    public String newMovieList(Model model) {
        MovieList movieList = new MovieList();
        model.addAttribute("movieList", movieList);
        return "movie_list/movielist-form";
    }

    @GetMapping("/movieList/{movieListId}/update")
    public String updateMovieList(@PathVariable String movieListId, Model model){
        model.addAttribute("movieList", movieListService.findById(Long.valueOf(movieListId)));
        return "movie_list/movielist-form";
    }

    @PostMapping("/movieList")
    public String saveOrUpdateMovieList(@ModelAttribute MovieList movieList){
        movieListService.save(movieList);
        return "redirect:/";
    }

    @GetMapping("movieList/{movielistId}/delete")
    public String deleteMovieList(@PathVariable String movielistId){
        movieListService.deleteById(Long.valueOf(movielistId));
        return "redirect:/";
    }

}
