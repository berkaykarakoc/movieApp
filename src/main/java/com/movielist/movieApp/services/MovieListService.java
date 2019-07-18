package com.movielist.movieApp.services;

import com.movielist.movieApp.models.MovieList;

import java.util.Set;

public interface MovieListService {

    Set<MovieList> getMovieLists();

    MovieList findById(Long l);

    void deleteById(Long l);

    void save(MovieList movieList);

}
