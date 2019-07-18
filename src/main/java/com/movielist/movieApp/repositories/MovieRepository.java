package com.movielist.movieApp.repositories;

import com.movielist.movieApp.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
