package com.cognizant.truyum.controller;

import java.util.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.truyum.exception.CartNullException;
import com.cognizant.truyum.exception.MovieNotFoundException;
import com.cognizant.truyum.exception.UserNotExistsException;
import com.cognizant.truyum.model.Movies;
import com.cognizant.truyum.service.FavouritesService;

@RestController
@RequestMapping("/carts")
public class FavouritesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FavouritesController.class);

	@Autowired
	private FavouritesService cartService;

	public FavouritesController() {
		LOGGER.info("Inside Cart Controller Construtor");
	}
	@DeleteMapping("/{userId}/{movieId}")
	public void deleteCartItem(@PathVariable String userId, @PathVariable long movieId)
			throws UserNotExistsException, CartNullException, MovieNotFoundException {
		LOGGER.info("Inside delete Cart Item inside Cart Controller");
		cartService.deleteCartItem(userId, movieId);
		LOGGER.debug("Movie deleted");
	}

	@GetMapping("/{userId}")
	public HashMap<List<Movies>, Long> getAllMovies(@PathVariable String userId)
			throws UserNotExistsException, CartNullException {
		LOGGER.info("Inside get All movies in Controller");
		HashMap<List<Movies>, Long> mlist = cartService.getAllMovies(userId);
		LOGGER.debug("Movies List: {}, Total :{}", mlist.keySet(), mlist.values());
		return mlist;
	}

	@PostMapping("/{userId}/{id}")
	public void addToCart(@PathVariable String userId, @PathVariable long id) throws MovieNotFoundException {
		LOGGER.info("Inside add to Cart in Controller");
		cartService.addToCart(userId, id);
		LOGGER.info("Added To Cart of User Id " + userId);

	}



}
