package com.stackroute.service;


import com.stackroute.domain.MovieApp;
import com.stackroute.repository.MovieAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieAppServiceImpl implements MovieAppService {

    MovieAppRepository movieAppRepository;
    @Autowired
    public MovieAppServiceImpl(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }


    @Override
    public MovieApp saveMovie(MovieApp movie) {
        MovieApp movieApp=movieAppRepository.save(movie);
        return  movieApp;
    }

    @Override
    public List<MovieApp> getAllMovies() {
        return movieAppRepository.findAll();
    }

    @Override
    public boolean deleteMovie(String movieId) {
        if (movieAppRepository.existsById(movieId)){
            movieAppRepository.deleteById(movieId);
        return true;
    }
        return false;
    }
//
//    @Override
//    public MovieApp getMovieByName(String movieName) {
//
//
//
//
//    }

    @Override
    public MovieApp updateMovie(MovieApp movie) {
        MovieApp movie1=new MovieApp();
        if(movieAppRepository.existsById(movie.getId())){
            movie1=movieAppRepository.save(movie);
        }
        return movie1;
    }
}



