package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.MovieRepositories;

public class MovieApiControllerTest {

	private MovieRepositories repo;
	private MovieApiController controller;

	@Before
	public void setUp() {
		repo = mock(MovieRepositories.class);
		controller = new MovieApiController(repo);
	}
	
	@Test
	public void create_movie_and_ensure_it_saves() {
		
		Movie movie=new Movie();
		
		when(repo.save(movie)).thenReturn(movie);
		
		Movie newMovie = controller.createMovie(movie);
		
		assertThat(movie).isSameAs(newMovie);
	}
	
	@Test
	public void find_a_movie_based_on_id() {
		
		Movie movie=new Movie();
		
		when(repo.findOne(1l)).thenReturn(movie);
		
		Movie newMovie = controller.getOneMovie(1l);
		
		assertThat(movie).isSameAs(newMovie);
	}
	
	@Test
	public void ensure_movie_can_be_updated_with_new_movie() {
		
		Movie movie=new Movie();
		
		when(repo.save(movie)).thenReturn(movie);
		
		movie.setId(1l);
		
		Movie newMovie = controller.UpdateMovie(movie,1l);
		
		assertThat(movie).isSameAs(newMovie);
	}
	
	
	@Test
	public void ensure_movie_can_be_deleted_by_id() {
		
		Movie movie=new Movie();
		
		when(repo.findOne(12l)).thenReturn(movie);
		
		Movie newMovie = controller.deleteMovie(12l);
		
		assertThat(movie).isSameAs(newMovie);
		
		verify(repo).delete(12l);
		
	}
	
	@Test
	public void get_all_movies_as_list() {
		List<Movie> movies = new ArrayList<Movie>();
		
		when(repo.findAll()).thenReturn(movies); 
		
		List<Movie> newMovies = controller.getMovie();
		
		assertThat(movies).isSameAs(newMovies);
		
		
	}
	
	
	
	
	
	
}
