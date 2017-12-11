package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepositories;
import com.lmig.gfc.wimp.repositories.MovieRepositories;

public class TheCastApiControllerTest {

	private ActorRepositories repo;
	private MovieRepositories movieRepo;
	private TheCastApiController controller;

	@Before
	public void setUp() {
		repo = mock(ActorRepositories.class);
		movieRepo = mock(MovieRepositories.class);
		controller = new TheCastApiController(repo, movieRepo);
	}

	@Test
	public void create_movie_and_associate_an_actor_where_actor_already_associated() {

		Actor actor = new Actor();
		Movie movie = new Movie();

		List<Actor> cast = new ArrayList<Actor>();

		cast.add(actor);

		movie.setCast(cast);

		when(repo.findOne(1l)).thenReturn(actor);
		when(movieRepo.findOne(47l)).thenReturn(movie);

		Movie newMovie = controller.create(47l, 1l);

		assertThat(movie).isSameAs(newMovie);

		verify(movieRepo, never()).save(movie);

	}
	
	@Test
	public void create_movie_and_associate_an_actor() {

		Actor actor = new Actor();
		Movie movie = new Movie();


		movie.setCast(new ArrayList<Actor>());

		when(repo.findOne(1l)).thenReturn(actor);
		when(movieRepo.findOne(47l)).thenReturn(movie);

		Movie newMovie = controller.create(47l, 1l);

		assertThat(movie).isSameAs(newMovie);

		verify(movieRepo).save(movie);
		
		assertThat(movie.getCast()).hasSize(1);

	}
	
	
}
