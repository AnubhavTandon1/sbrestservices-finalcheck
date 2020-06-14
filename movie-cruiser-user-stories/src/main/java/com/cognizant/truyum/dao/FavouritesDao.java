package com.cognizant.truyum.dao;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.exception.CartNullException;
import com.cognizant.truyum.exception.MovieNotFoundException;
import com.cognizant.truyum.exception.UserNotExistsException;
import com.cognizant.truyum.model.Movies;

public interface FavouritesDao {
	
	void addToCart(String user, long id) throws MovieNotFoundException; 
	
	HashMap<List<Movies>,Long> getAllMovies(String userId) throws UserNotExistsException, CartNullException;

	void deleteCartItem(String userId, long movieId)
			throws UserNotExistsException, CartNullException, MovieNotFoundException;
}
