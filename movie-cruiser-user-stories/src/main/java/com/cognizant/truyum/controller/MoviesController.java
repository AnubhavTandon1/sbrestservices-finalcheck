package com.cognizant.truyum.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.MovieNotFoundException;
import com.cognizant.truyum.exception.InActiveException;
import com.cognizant.truyum.model.Movies;
import com.cognizant.truyum.service.MoviesService;

@RestController
@RequestMapping("/movies")
public class MoviesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviesController.class);
	public MoviesController() {
		LOGGER.info("Inside Movie Controller Constructor");
	}
	@Autowired
	private MoviesService movieService;
	
	@GetMapping
	public ArrayList<Movies> getMovieListCustomer(){
		LOGGER.info("Inside getMovie List of Controller");
		ArrayList<Movies> mlist=movieService.getMovieListCustomer();
		LOGGER.debug("Movie List :: {}",mlist);
		
		return mlist;
	}
	
	@GetMapping("/{id}")
	public Movies getMovie(@PathVariable long id) throws MovieNotFoundException {
		LOGGER.info("Inside getMovie of Controller");
		Movies movie=movieService.getMovie(id);
		LOGGER.debug("Movie :: {}",movie.toString());
		return movie;
	}
	
	@PutMapping
	public void modifyMovieDetails(@RequestBody Movies movie) throws MovieNotFoundException {
		LOGGER.info("Inside Modify Movie details in Controller" );
		movieService.modifyMovie(movie);
		LOGGER.debug("Update Movie :: {} ",movie);
	}
	
	@GetMapping("/active")
	public ArrayList<Movies> getActiveAndNotInFutureMovies() throws InActiveException{
		LOGGER.info("Inside Active Movies in Controller");
		ArrayList<Movies> mlist=movieService.getActiveAndNotInFutureMovies();
		LOGGER.debug("Active Movies :: {} ",mlist);
		return mlist;
	}
}
