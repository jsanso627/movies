package org.example.helloweb.dao;

import org.example.helloweb.model.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> findAll();
    Movie findById(Long id);
    void create(Movie movie);
    void delete(long id);
    void update(Movie movie);
}
