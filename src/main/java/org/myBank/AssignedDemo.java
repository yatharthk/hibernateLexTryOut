package org.myBank;

import org.myBank.dao.MovieDao;
import org.myBank.dao.MovieDaoImpl;
import org.myBank.entity.Movie;
import org.myBank.service.MovieService;
import org.myBank.service.MovieServiceImpl;

import java.util.logging.Logger;

public class AssignedDemo {

    static Logger LOG = Logger.getLogger(AssignedDemo.class.getName());
    public static void main(String[] args) {
        MovieDao movieDao = new MovieDaoImpl();
        MovieService movieService = new MovieServiceImpl(movieDao);
        try {
            LOG.info("Enter the Movie details");
            Movie movie = new Movie("1100","Piku","Hindi",2015,210000);
            movieService.addMovie(movie);
            LOG.info("One record created");
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
    }
}
