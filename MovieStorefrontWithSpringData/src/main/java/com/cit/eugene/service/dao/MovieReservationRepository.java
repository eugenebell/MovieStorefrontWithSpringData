package com.cit.eugene.service.dao;

import org.springframework.data.repository.CrudRepository;

import com.cit.eugene.model.MovieReservation;

/**
 * Used to manage the MovieReservation DAO layer.
 * 
 * @author Eugene Bell
 */
public interface MovieReservationRepository extends CrudRepository<MovieReservation, Long>  {
	
}
