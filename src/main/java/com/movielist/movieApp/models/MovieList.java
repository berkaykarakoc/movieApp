package com.movielist.movieApp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "movieList", cascade = CascadeType.ALL)
    private Set<Movie> movies;

    public MovieList() {
    }

    public MovieList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public Movie removeMovie(Movie movie) {
        movies.remove(movie);
        return movie;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "id=" + id +
                ", movies=" + movies +
                '}';
    }

}
