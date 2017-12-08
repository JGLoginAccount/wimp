package com.lmig.gfc.wimp.api;

import java.util.ArrayList;
import java.util.List;
import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;

public class ActorView {
	
	Actor actor;
	
	public ActorView(Actor actor) {
		this.actor=actor;
	}
	
	public Long getId() {
		return actor.getId();
	}
	
	public String getFirstName() {
		return actor.getFirstName();
	}
	
	public String getLastName() {
		return actor.getLastName();
	}
	
	public List<MovieView> getMovies() {
		
		ArrayList<MovieView> movies = new ArrayList<MovieView>();
		for (Movie movie:actor.getMovies()) {
			movies.add(new MovieView(movie));
		}
		
		
		return movies;
	}
	
	public List<Award> getAwards() {
		
	
		
		return actor.getAwards(); 
	}
	

	
	





}






