package com.stackroute.service;

import com.stackroute.domain.MovieApp;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieAppService {

    public MovieApp saveMovie(MovieApp movie);
    public List<MovieApp> getAllMovies();
    public boolean deleteMovie(String movieId);
//    public MovieApp getMovieByName(String movieName);
    public MovieApp updateMovie(MovieApp movie);

}

