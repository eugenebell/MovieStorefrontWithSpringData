package com.cit.eugene.service.business;

import java.util.List;

import com.cit.eugene.model.Genre;

/**
 * Class is for the Management of Genres.
 * 
 * @author Eugene Bell
 */
public interface GenreService {

	/**
	 * Returns the list of genres.
	 * 
	 * @return List<Genre>
	 */
	public List<Genre> getGenreListing();
	
}
