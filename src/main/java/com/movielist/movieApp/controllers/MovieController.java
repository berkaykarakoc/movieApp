package com.movielist.movieApp.controllers;

import com.movielist.movieApp.models.Movie;
import com.movielist.movieApp.models.MovieList;
import com.movielist.movieApp.services.MovieListService;
import com.movielist.movieApp.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private MovieService movieService;
    private MovieListService movieListService;

    public MovieController(MovieService movieService, MovieListService movieListService) {
        this.movieService = movieService;
        this.movieListService = movieListService;
    }

    @GetMapping("/movieList/{movieListId}/movie/{movieId}/show")
    public String showMovie(@PathVariable String movieListId, @PathVariable String movieId, Model model) {
        model.addAttribute("movie", movieService.findByMovieListIdAndMovieId(Long.valueOf(movieListId), Long.valueOf(movieId)));
        return "movie_list/movie/show";
    }

    @GetMapping("movieList/{movieListId}/movie/new")
    public String newMovie(@PathVariable String movieListId, Model model) {
        MovieList movieList = movieListService.findById(Long.valueOf(movieListId));
        Movie movie = new Movie();
        movie.setMovieList(movieList);
        movieList.addMovie(movie);
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

        return "redirect:/movieList/" + movie.getMovieList().getId() + "/show";
    }

    @GetMapping("movieList/{movieListId}/movie/{movieId}/delete")
    public String deleteMovie(@PathVariable String movieListId,
                                   @PathVariable String movieId){

        movieService.deleteById(Long.valueOf(movieListId), Long.valueOf(movieId));

        return "redirect:/movieList/" + movieListId + "/show";
    }

}
