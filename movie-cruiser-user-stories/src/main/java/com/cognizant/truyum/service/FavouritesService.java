package com.cognizant.truyum.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.truyum.dao.FavouritesDao;
import com.cognizant.truyum.exception.CartNullException;
import com.cognizant.truyum.exception.MovieNotFoundException;
import com.cognizant.truyum.exception.UserNotExistsException;
import com.cognizant.truyum.model.Movies;
@Service
public class FavouritesService {

	@Autowired
	private FavouritesDao cartDao;

	public void addToCart(String user, long id) throws MovieNotFoundException {
		cartDao.addToCart(user, id);
	}

	public HashMap<List<Movies>, Long> getAllMovies(String userId) throws UserNotExistsException, CartNullException {
		return cartDao.getAllMovies(userId);
	}

	public void deleteCartItem(String userId, long menuItemId)
			throws UserNotExistsException, CartNullException, MovieNotFoundException {
		cartDao.deleteCartItem(userId, menuItemId);
	}
}
