package com.cit.eugene.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;

import com.cit.eugene.model.Movie;

/**
 * Used to manage the Movie DAO layer.
 * 
 * @author Eugene Bell
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {

	/**
	 * Get all movies.
	 * 
	 * @return List<Movie>
	 */
	@Secured({"ROLE_USER", "ROLE_ADMIN"}) 
	List<Movie> findAll();//getAllMovies();
	
	/**
	 * Get all movie by genre ID.
	 * 
	 * @param genreID
	 * @return List<Movie>
	 */
	@Secured({"ROLE_USER", "ROLE_ADMIN"}) 
	@Query("SELECT m FROM Movie m INNER JOIN m.genres g WHERE g.genreID IN (:genreID)")
	List<Movie> findByGenreID(@Param("genreID") Long genreID); //getMovieListingByGenreID(Long genreID);
	
	/**
	 * Get movie by id.
	 * 
	 * @param movieID
	 * @return Movie
	 */
	@Secured({"ROLE_USER", "ROLE_ADMIN"}) 
	Movie findByMovieID(Long movieID);
	
}
