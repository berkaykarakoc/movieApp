package com.movielist.movieApp.services;

import com.movielist.movieApp.models.Movie;

public interface MovieService {

    Movie findByMovieListIdAndMovieId(Long movieListId, Long movieId);

    void deleteById(Long l);

    void save(Movie movie);

    void deleteById(Long movieListId, Long movieId);

}
