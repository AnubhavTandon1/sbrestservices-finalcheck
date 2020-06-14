package com.cognizant.truyum.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.truyum.dao.MovieDao;
import com.cognizant.truyum.exception.MovieNotFoundException;
import com.cognizant.truyum.exception.InActiveException;
import com.cognizant.truyum.model.Movies;

@Service
public class MoviesService {
	
	@Autowired
	private MovieDao movieDao;

	public ArrayList<Movies> getMovieListCustomer() {
		return movieDao.getMovieListCustomer();
	}
	
	public Movies getMovie(long id) throws MovieNotFoundException {
		return movieDao.getMovie(id);
	}
	
	public void modifyMovie(Movies movie) throws MovieNotFoundException
	{
		movieDao.modifyMovieDetails(movie);
	}
	
	public ArrayList<Movies> getActiveAndNotInFutureMovies() throws InActiveException{
		return movieDao.getActiveAndNotInFutureMovies();
	}
}
