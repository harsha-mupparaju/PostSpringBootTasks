package com.stackroute.controller;


import com.stackroute.domain.MovieApp;
import com.stackroute.service.MovieAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieAppcontroller {


    MovieAppService movieAppService;

    public MovieAppcontroller(MovieAppService movieService) {
        this.movieAppService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody MovieApp movie) {
        ResponseEntity responseEntity;

            movieAppService.saveMovie(movie);
            responseEntity = new ResponseEntity("Succesfully Created", HttpStatus.CREATED);
//        } catch (Exception ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//        }
        return responseEntity;
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies() {
        return new ResponseEntity<List<MovieApp>>(movieAppService.getAllMovies(), HttpStatus.OK);
    }


    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovie(@RequestBody String movieId){
        ResponseEntity responseEntity;
//        try{
            movieAppService.deleteMovie(movieId);
            return new ResponseEntity("Succesfully deleted", HttpStatus.OK);
//        }catch(Exception ex){
//            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//        }
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(MovieApp movie){
        ResponseEntity responseEntity;
        movieAppService.updateMovie(movie);
        return new ResponseEntity("Succesfully updated",HttpStatus.OK);
    }
}

