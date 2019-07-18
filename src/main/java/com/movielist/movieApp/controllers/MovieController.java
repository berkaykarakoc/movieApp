package com.movielist.movieApp.controllers;

import com.movielist.movieApp.models.Movie;
import com.movielist.movieApp.models.MovieList;
import com.movielist.movieApp.services.MovieListService;
import com.movielist.movieApp.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    private MovieService movieService;
    private MovieListService movieListService;

    public MovieController(MovieService movieService, MovieListService movieListService) {
        this.movieService = movieService;
        this.movieListService = movieListService;
    }

    @RequestMapping("/movieList/{movielistId}/movie/{movieId}/show")
    public String showMovie(@PathVariable String movielistId, @PathVariable String movieId, Model model) {
        model.addAttribute("movie", movieService.findByMovieListIdAndMovieId(Long.valueOf(movielistId), Long.valueOf(movieId)));
        return "movie_list/movie/show";
    }

    @GetMapping("movieList/{movieListId}/movie/new")
    public String newMovie(@PathVariable String movieListId, Model model) {
        MovieList movieList = movieListService.findById(Long.valueOf(movieListId));
        Movie movie = new Movie();
        movie.setMovieList(movieList);
        movieList.getMovies().add(movie);
        model.addAttribute("movie", movie);
        return "movie_list/movie/movie-form";
    }

    @GetMapping("/movieList/{movieListId}/movie/{movieId}/update")
    public String updateMovie(@PathVariable String movieListId,
                                         @PathVariable String movieId, Model model){
        model.addAttribute("movie", movieService.findByMovieListIdAndMovieId(Long.valueOf(movieListId), Long.valueOf(movieId)));

        return "movie_list/movie/movie-form";
    }

    @PostMapping("/movieList/{movieListId}/movie")
    public String saveOrUpdateMovie(@PathVariable String movieListId, @ModelAttribute Movie movie){
        MovieList movieList = movieListService.findById(Long.valueOf(movieListId));
        movie.setMovieList(movieList);
        movieService.save(movie);

        return "redirect:/movieList/" + movie.getMovieList().getId() + "/movie/" + movie.getId() + "/show";
    }

    @GetMapping("movieList/{movielistId}/movie/{movieId}/delete")
    public String deleteMovie(@PathVariable String movielistId,
                                   @PathVariable String movieId){

        movieService.deleteById(Long.valueOf(movielistId), Long.valueOf(movieId));

        return "redirect:/movieList/" + movielistId + "/show";
    }

}
