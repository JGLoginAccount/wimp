package com.lmig.gfc.wimp.api;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepositories;
import com.lmig.gfc.wimp.repositories.MovieRepositories;

@RestController
@RequestMapping("/api/movies/{movieId}/actors")
public class TheCastApiController {
	
	

	private ActorRepositories actorRepository;
	private MovieRepositories mr;

	public TheCastApiController(ActorRepositories actorRepository, MovieRepositories mr) {
		this.actorRepository = actorRepository;
		this.mr = mr;

	}
	

	@PostMapping("")
	public Movie create(@PathVariable Long movieId, @RequestBody Long actorId) {

		Movie movie = mr.findOne(movieId);
		Actor actor = actorRepository.findOne(actorId);
		
		if (!movie.getCast().contains(actor)) {
			movie.getCast().add(actor);
			mr.save(movie);
		}
		
		

		return movie;
	}

}
