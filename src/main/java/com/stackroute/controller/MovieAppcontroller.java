package com.stackroute.controller;


import com.stackroute.domain.MovieApp;
import com.stackroute.exceptions.MyMovieAppExceptions;
import com.stackroute.service.MovieAppService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/api")
public class MovieAppcontroller {


    MovieAppService movieAppService;

    public MovieAppcontroller(MovieAppService movieService) {
        this.movieAppService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody MovieApp movie) {
        ResponseEntity responseEntity;
     try{
            movieAppService.saveMovie(movie);
            responseEntity = new ResponseEntity("Succesfully Created", HttpStatus.CREATED);
        } catch (MyMovieAppExceptions ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("allMovies")
    public ResponseEntity<?> getAllMovies()  {
        return new ResponseEntity<List<MovieApp>>(movieAppService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("movie")
    public ResponseEntity<?> searchByMovieName(@RequestBody String movieName) {
        try {
            return new ResponseEntity(movieAppService.getMovieByName(movieName), HttpStatus.OK);
        } catch (MyMovieAppExceptions ex) {
           return  new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovie(@RequestBody String movieId){
        ResponseEntity responseEntity;
       try{
            movieAppService.deleteMovie(movieId);
            return new ResponseEntity("Succesfully deleted", HttpStatus.OK);
        }catch(MyMovieAppExceptions ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(MovieApp movie){
        ResponseEntity responseEntity;
        movieAppService.updateMovie(movie);
        return new ResponseEntity("Succesfully updated",HttpStatus.OK);
    }
}

