package com.gdu.movie.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gdu.movie.domain.MovieDTO;

public interface MovieService {
	
	public List<MovieDTO> getMovieList();
	public List<MovieDTO> findMovie(HttpServletRequest request);
}
