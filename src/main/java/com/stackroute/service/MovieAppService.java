package com.stackroute.service;

import com.stackroute.domain.MovieApp;
import com.stackroute.exceptions.MyMovieAppExceptions;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieAppService {

    public MovieApp saveMovie(MovieApp movie) throws MyMovieAppExceptions;
    public List<MovieApp> getAllMovies();
    public boolean deleteMovie(String movieId) throws MyMovieAppExceptions;
    public MovieApp getMovieByName(String movieName) throws MyMovieAppExceptions;
    public MovieApp updateMovie(MovieApp movie);

}

