package com.stackroute.service;


import com.stackroute.domain.MovieApp;
import com.stackroute.exceptions.MyMovieAppExceptions;
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
    public MovieApp saveMovie(MovieApp movie) throws MyMovieAppExceptions {
        if(movieAppRepository.existsById(movie.getId())) {
        throw new MyMovieAppExceptions("Movie already exists");
        }
        MovieApp savedmovie=movieAppRepository.save(movie);
        if(savedmovie==null){
            throw new MyMovieAppExceptions("Movie already exists");
        }
        return  savedmovie;
    }

    @Override
    public List<MovieApp> getAllMovies() {
        return movieAppRepository.findAll();
    }

    @Override
    public boolean deleteMovie(String movieId) throws MyMovieAppExceptions {
        if (movieAppRepository.existsById(movieId)){
            movieAppRepository.deleteById(movieId);
        return true;
    }else{
            throw new MyMovieAppExceptions("No such id exists to delete ");
        }

   }
//
//    @Override
//    public MovieApp getMovieByName(String movieName) {
//        return null;
//    }
//
    @Override
    public MovieApp getMovieByName(String movieName) throws MyMovieAppExceptions {
      MovieApp movie=new MovieApp();
//       if(movieAppRepository.findByMovieTitle(movieName)==movie.getTitle()){
    Optional<MovieApp> movie1= movieAppRepository.findByMovieTitle(movieName);
    if(movie1.isPresent()){
        movie=movie1.get();
     return movie;
    }else
        throw new MyMovieAppExceptions("No such Movie Title exists");
    }

    @Override
    public MovieApp updateMovie(MovieApp movie) {
        MovieApp movie1=new MovieApp();
        if(movieAppRepository.existsById(movie.getId())){
            movie1=movieAppRepository.save(movie);
        }
        return movie1;
    }
}



