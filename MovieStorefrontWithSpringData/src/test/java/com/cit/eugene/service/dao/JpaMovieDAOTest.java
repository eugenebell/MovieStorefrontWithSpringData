package com.cit.eugene.service.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cit.eugene.model.Movie;

@ContextConfiguration("file:src/test/resources/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class JpaMovieDAOTest {

	@Autowired
	private GenreRepository jpaGenre;
	@Autowired
	private MovieRepository jpaMovie;

	@Test
	public void testGetAllMovies() {
		List<Movie> l = jpaMovie.findAll();
		assertEquals(25, l.size());
	}

	@Test
	public void testGetMovieListingByGenreID() {
		
		List<Movie> l1  = jpaMovie.findByGenreID(2l);
		assertEquals(11, l1.size());
		List<Movie> l2  = jpaMovie.findByGenreID(5l);
		assertEquals(5, l2.size());
		List<Movie> l3  = jpaMovie.findByGenreID(6l);
		assertEquals(15, l3.size());
		List<Movie> l4  = jpaMovie.findByGenreID(9l);
		assertEquals(3, l4.size());
	}

	@Test
	public void testGetMovieByID() {
		Movie m = jpaMovie.findByMovieID(1l);
		assertNotNull(m);
		assertEquals("13 Assassins", m.getTitle());
		assertEquals("13_Assassins.jpg", m.getPosterFileName());
		assertEquals("A group of assassins come together for a suicide mission to kill an evil lord.", m.getSummary());
		assertEquals(2010, m.getYear().intValue());
		assertEquals("Takashi Miike", m.getDirectorsDisplay());
		assertEquals("", m.getProducersDisplay());
		assertEquals("141 min", m.getDisplayRunTime());
		assertEquals("", m.getStudioDisplay());
		assertEquals(false, m.isRented());
		assertEquals("3.99", m.getPrice().toString());
		assertEquals(2, m.getRating().intValue());
		assertEquals(3, m.getGenres().size());
	}
	
//	@Test
//	public void testGetMovieByIDReturningNull() {
//		Movie m = jpaMovie.findByMovieID(10000l);
//		assertNull(m);
//	}

}
