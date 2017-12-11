package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.repositories.ActorRepositories;

public class ActorApiControllerTest {

	private ActorRepositories repo;
	private ActorApiController controller;

	@Before
	public void setUp() {
		repo = mock(ActorRepositories.class);
		controller = new ActorApiController(repo);
	}

	@Test
	public void get_All_actors() {

		ArrayList<Actor> actors = new ArrayList<Actor>();
		
		Actor actor = new Actor();
		
		actors.add(actor);

		when(repo.findAll()).thenReturn(actors);

		List<ActorView> actorViews = controller.getActor();
		
		for (int i = 0;i<actors.size();i=i+1) {
		assertThat(actors.get(i)).isSameAs(actorViews.get(i).actor);
		
		}
		
		assertThat(actors.size()).isSameAs(actorViews.size());

	}

	@Test
	public void create_Actor_And_Ensure_Actor_object_properly_made() {

		// Arrange
		Actor actor = new Actor();
		when(repo.save(actor)).thenReturn(actor);

		// Act
		Actor newActor = controller.createActor(actor);

		// Assess
		assertThat(actor).isSameAs(newActor);
	}

	@Test
	public void identify_Single_Actor_Based_o_ID() {
		// Arrange
		Actor actor = new Actor();
		when(repo.findOne(1l)).thenReturn(actor);

		// Act
		ActorView newActor = controller.getOneActor(1l);

		// Assess
		assertThat(actor).isSameAs(newActor.actor);

	}
	
	

	@Test
	public void update_Actor_Based_On_Values_Passed_in() {
		// Arrange
		Actor actor = new Actor();
		actor.setId(1l);
		when(repo.save(actor)).thenReturn(actor);

		// Act
		Actor newActor = controller.updateActor(actor, 1l);

		// Assess
		assertThat(actor).isSameAs(newActor);
		assertThat(actor.getId()).isSameAs(newActor.getId());

	}

	@Test
	public void delete_removes_dog() {
		Actor actor = new Actor();

		when(repo.findOne(1L)).thenReturn(actor);

		Actor newActor = controller.deleteActor(1L);

		assertThat(actor).isSameAs(newActor);
		verify(repo).delete(1L);

	}

}
