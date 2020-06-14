package com.cognizant.truyum.dao;

import java.util.ArrayList;


import com.cognizant.truyum.exception.MovieNotFoundException;
import com.cognizant.truyum.exception.InActiveException;
import com.cognizant.truyum.model.Movies;


public interface MovieDao {
	public ArrayList<Movies> getMovieListCustomer();
	public Movies getMovie(long id) throws MovieNotFoundException;
	public void modifyMovieDetails(Movies movie) throws MovieNotFoundException;
	public ArrayList<Movies> getActiveAndNotInFutureMovies()throws InActiveException;
}
