package com.movielist.movieApp.services;

import com.movielist.movieApp.models.MovieList;
import com.movielist.movieApp.repositories.MovieListRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieListServiceImpl implements MovieListService {

    private MovieListRepository movieListRepository;

    public MovieListServiceImpl(MovieListRepository movieListRepository) {
        this.movieListRepository = movieListRepository;
    }

    @Override
    public Set<MovieList> getMovieLists() {

        Set<MovieList> movieListList = new HashSet<>();
        movieListRepository.findAll().iterator().forEachRemaining(movieListList::add);
        return movieListList;
    }

    @Override
    public MovieList findById(Long l) {
        Optional<MovieList> movieListOptional = movieListRepository.findById(l);

        if (!movieListOptional.isPresent()) {
            throw new RuntimeException("Movie List Not Found");
        }

        return movieListOptional.get();
    }

    @Override
    public void deleteById(Long l) {
        movieListRepository.deleteById(l);
    }

    @Override
    public void save(MovieList movieList) {
        movieListRepository.save(movieList);
    }
}
