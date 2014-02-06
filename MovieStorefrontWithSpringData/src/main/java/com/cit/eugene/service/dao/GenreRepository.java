package com.cit.eugene.service.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.annotation.Secured;

import com.cit.eugene.model.Genre;

/**
 * Used to manage the Genre DAO layer.
 * 
 * @author Eugene Bell
 */
public interface GenreRepository extends CrudRepository<Genre, Long> {

	/**
	 * Get all genres.
	 * 
	 * @return List<Genre>
	 */
	@Secured("ROLE_USER")
	List<Genre> findAll();//getAllGenres();
	
}
