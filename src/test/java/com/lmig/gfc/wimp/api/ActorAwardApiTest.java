package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.repositories.ActorRepositories;
import com.lmig.gfc.wimp.repositories.AwardReposirtory;

public class ActorAwardApiTest {


	private ActorRepositories repo;
	private AwardReposirtory awardR;
	private ActorAwardApi controller;

	@Before
	public void setUp() {
		repo = mock(ActorRepositories.class);
		awardR = mock(AwardReposirtory.class);
		controller = new ActorAwardApi(repo,awardR);
	}
	@Test
	public void create_new_actor_and_ensure_award_can_be_Associated() {
		
		Actor actor = new Actor();
		Award award = new Award();
		
		List <Award> awards = new ArrayList<Award>();
		actor.setAwards(awards);
		awards.add(award);
		
		when(repo.findOne(1L)).thenReturn(actor);
	
		Actor newActor = controller.create(award,1l);
		
		assertThat(actor).isSameAs(newActor);
		assertThat(actor.getAwards()).isSameAs(newActor.getAwards());
		
	}
	
	
	
	
	
	
	
}
