package com.lmig.gfc.wimp.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.repositories.ActorRepositories;

@RestController
@RequestMapping("/api/actors")
public class ActorApiController {

	private ActorRepositories actorRepositories;

	public ActorApiController(ActorRepositories actorRepositories) {
		this.actorRepositories = actorRepositories;

	}

	@GetMapping("")
	public List<ActorView> getActor() {
		
		List<Actor> actors=actorRepositories.findAll();
		
		ArrayList<ActorView> actorViews=new ArrayList<ActorView>();
		
		for (Actor actor:actors) {
			actorViews.add(new ActorView(actor));
		}
		
		return actorViews;

	}
	

	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Actor createActor(@RequestBody Actor actor) {
		
		return actorRepositories.save(actor);

	}

	@GetMapping("{id}")
	public ActorView getOneActor(@PathVariable long id) {
		
		
		Actor actor=actorRepositories.findOne(id);
		ActorView actorView = new ActorView(actor);
		
		return actorView;

	}

	@PutMapping("{id}")
	public Actor updateActor(@RequestBody Actor actor, @PathVariable long id) {
		
		actor.setId(id);
		
		return actorRepositories.save(actor);

	}

	@DeleteMapping("{id}")
	public Actor deleteActor(@PathVariable long id) {
		
		Actor actor=actorRepositories.findOne(id);
		actorRepositories.delete(id);
		return actor;

	}
	
}
