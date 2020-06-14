package com.cognizant.truyum.dao;

import java.util.ArrayList;


import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.truyum.exception.MovieNotFoundException;
import com.cognizant.truyum.exception.InActiveException;
import com.cognizant.truyum.model.Movies;

@Service
public class MovieDaoCollectionImpl implements MovieDao {

	private static ArrayList<Movies> movieList;
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("movie.xml");
		movieList = (ArrayList<Movies>) context.getBean("movieList");
	}

	@Override
	public ArrayList<Movies> getMovieListCustomer() {
		return movieList;
	}

	@Override
	public Movies getMovie(long id) throws MovieNotFoundException {
		Movies movie = null;
		for (Movies m : movieList) {
			if (m.getId() == id) {
				movie = m;
				break;
			}
		}
		if (movie == null)
			throw new MovieNotFoundException("Movie of Id " + id + " Not Found");
		return movie;
	}

	@Override
	public void modifyMovieDetails(Movies movie) throws MovieNotFoundException {
		int pos = 0;
		Movies mfnd = null;
		for (Movies m : movieList) {
			if (m.getId() == movie.getId()) {
				mfnd = m;
				break;
			}
			pos++;
		}
		if (mfnd == null)
			throw new MovieNotFoundException("Movie with id : " + movie.getId() + "Not Found");
		else {
			movieList.set(pos, movie);
		}
	}

	@Override
	public ArrayList<Movies> getActiveAndNotInFutureMovies() throws InActiveException {
		ArrayList<Movies> active = new ArrayList<Movies>();
		Date current = new Date(System.currentTimeMillis());
		for (Movies m : movieList) {
			if (m.isActive() && current.after(m.getDateOfLaunch()))
				active.add(m);
		}
		if (active.size() == 0)
			throw new InActiveException("not Active");
		return active;
	}

}
