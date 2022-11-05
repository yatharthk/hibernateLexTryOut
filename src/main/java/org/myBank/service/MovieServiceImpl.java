package org.myBank.service;

import org.myBank.dao.MovieDao;
import org.myBank.entity.Movie;

public class MovieServiceImpl implements  MovieService{

    private MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao){
        this.movieDao = movieDao;
    }

    @Override
    public void addMovie(Movie m) {
        this.movieDao.addMovie(m);
    }
}
