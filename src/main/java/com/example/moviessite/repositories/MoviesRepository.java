package com.example.moviessite.repositories;

import com.example.moviessite.entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movie, Integer> {
}
