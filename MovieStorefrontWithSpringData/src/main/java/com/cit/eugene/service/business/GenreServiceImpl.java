package com.cit.eugene.service.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cit.eugene.model.Genre;
import com.cit.eugene.service.dao.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

	private static final Logger LOG = Logger.getLogger(GenreServiceImpl.class);
	
	@Autowired
	private GenreRepository genreRepository;
	
	@PostConstruct
	void init() {
		LOG.info("GenreManagerImpl Has been Created");
	}
	
	@PreDestroy
	void destroy() {
		LOG.info("GenreManagerImpl Has been Destroyed");
	}

	public void setGenreRepository(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	@Transactional(readOnly=true)
	public List<Genre> getGenreListing() {
		return genreRepository.findAll();
	}
	
}
