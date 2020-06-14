package com.cognizant.truyum.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Favourites {
	private List<Movies> movieList;

	private long total;

	private static final Logger LOGGER = LoggerFactory.getLogger(Favourites.class);

	public Favourites() {
		LOGGER.info("Facourites() Constructor");
		movieList=new ArrayList<Movies>();
	}

	public List<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movies> movieList) {
		this.movieList = movieList;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	
}