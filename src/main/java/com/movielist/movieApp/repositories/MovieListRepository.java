package com.movielist.movieApp.repositories;

import com.movielist.movieApp.models.MovieList;
import org.springframework.data.repository.CrudRepository;

public interface MovieListRepository extends CrudRepository<MovieList, Long> {
}
