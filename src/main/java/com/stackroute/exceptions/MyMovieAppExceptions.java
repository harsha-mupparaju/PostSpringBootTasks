package com.stackroute.exceptions;

import com.stackroute.domain.MovieApp;

public class MyMovieAppExceptions extends Exception {
    private String message;

    public MyMovieAppExceptions(String message) {
        super(message);
        this.message = message;
    }
}
