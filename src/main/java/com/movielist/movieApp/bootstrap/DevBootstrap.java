package com.movielist.movieApp.bootstrap;

import com.movielist.movieApp.models.Movie;
import com.movielist.movieApp.models.MovieList;
import com.movielist.movieApp.repositories.MovieListRepository;
import com.movielist.movieApp.repositories.MovieRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private MovieListRepository movieListRepository;
    private MovieRepository movieRepository;

    public DevBootstrap(MovieListRepository movieListRepository, MovieRepository movieRepository) {
        this.movieListRepository = movieListRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movieListRepository.saveAll(getMovieLists());
    }

    public List<MovieList> getMovieLists() {

        // List of movie lists
        List<MovieList> myMl = new ArrayList<>();


        // 1.
        Set<Movie> movies1 = new HashSet<>();
        Movie m1 = new Movie("Lord of the Rings", "9.0");
        m1.setComment("The best fantasy movie ever!");
        Movie m2 = new Movie("Forest Gump", "8.9");
        m2.setComment("Forest Gump <3");
        Movie m3 = new Movie("Shawshank Redemption", "9.1");
        m3.setComment("Hope...");

        movies1.add(m1);
        movies1.add(m2);
        movies1.add(m3);

        MovieList ml1 = new MovieList("Berkay List");

        m1.setMovieList(ml1);
        m2.setMovieList(ml1);
        m3.setMovieList(ml1);

        ml1.setMovies(movies1);


        // 2.
        Set<Movie> movies2 = new HashSet<>();
        Movie m4 = new Movie("Spider-Man: Far From Home", "8.0");
        m4.setComment("Spydee!");
        Movie m5 = new Movie("Avengers: End Game", "7.5");
        m5.setComment("Could be better...");

        movies2.add(m4);
        movies2.add(m5);
        movies2.add(m1);

        MovieList ml2 = new MovieList("SA");

        m4.setMovieList(ml2);
        m5.setMovieList(ml2);

        ml2.setMovies(movies2);


        // Add movie lists
        myMl.add(ml1);
        myMl.add(ml2);

        return myMl;
    }

}
