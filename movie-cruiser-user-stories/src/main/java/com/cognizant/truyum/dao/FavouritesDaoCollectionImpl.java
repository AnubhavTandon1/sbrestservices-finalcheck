package com.cognizant.truyum.dao;
import java.util.HashMap;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.CartNullException;
import com.cognizant.truyum.exception.MovieNotFoundException;
import com.cognizant.truyum.exception.UserNotExistsException;
import com.cognizant.truyum.model.Favourites;
import com.cognizant.truyum.model.Movies;

@Service
public class FavouritesDaoCollectionImpl implements FavouritesDao {

	private static HashMap<String, Favourites> userCarts;

	public FavouritesDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Favourites>();
		}
	}

	@Override
	public void addToCart(String user, long id) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movies movie = null;
		movie = movieDao.getMovie(id);
		if (movie == null)
			throw new MovieNotFoundException("Movie with id " + id + " mot found");
		else {
			if (userCarts.containsKey(user)) {
				List<Movies> list = userCarts.get(user).getMovieList();
				list.add(movie);
			} else {
				Favourites cart = new Favourites();
				cart.getMovieList().add(movie);
				userCarts.put(user, cart);
			}
		}
	}

	@Override
	public HashMap<List<Movies>, Long> getAllMovies(String userId) throws UserNotExistsException, CartNullException {
		// TODO Auto-generated method stub
		long total=0;
		if(userCarts.containsKey(userId)) {
			List<Movies> list=userCarts.get(userId).getMovieList();
			total=list.size();
			if(total==0)
				throw new CartNullException("Your Cart is Empty");
			userCarts.get(userId).setTotal(total);
			HashMap<List<Movies>,Long> hm=new HashMap<>();
			hm.put(list, total);
			return hm;
		}
		else
			throw new UserNotExistsException("User with id: "+userId+" Not Found ");
	}
	
	@Override
	public void deleteCartItem(String userId, long movieId) throws UserNotExistsException, CartNullException, MovieNotFoundException {
		if(userCarts.size()==0)
			throw new UserNotExistsException();
		if(userCarts.containsKey(userId)) {
			
			List<Movies> movieList = userCarts.get(userId).getMovieList();
			if (movieList.isEmpty()) {
				throw new CartNullException("Cart is Empty");
			} 
			boolean deleted=false;
			for (int i = 0; i < movieList.size(); i++) {
				if (movieList.get(i).getId() == movieId) {
					movieList.remove(i);
					deleted=true;
					break;
				}
			}
			if(!deleted)
				throw new MovieNotFoundException("Movie with menuItemId "+movieId+" does not exists for User with userId "+ userId);
		}else
			throw new UserNotExistsException("User with userid "+userId+" does not exist");
		
	}

}
