package com.lmig.gfc.wimp.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepositories;
import com.lmig.gfc.wimp.repositories.AwardReposirtory;
import com.lmig.gfc.wimp.repositories.MovieRepositories;

@Configuration
public class SeedData {
	
	public SeedData(ActorRepositories actorRepositories, MovieRepositories movieRepositories, AwardReposirtory ar) {
		
		 
		
		actorRepositories.save(new Actor("Bob","Hope",null,null));
		
		actorRepositories.save(new Actor("Harrison","Hope",12L,null));
		
		Actor actor2=actorRepositories.save(new Actor("Harrison","Smith",null,null));
		
		movieRepositories.save(new Movie("The Big Red One",null,121L,"Miramax"));
	

		Movie movie = movieRepositories.save(new Movie("Disaster Artist",null,121L,"Miramax"));
	
		
		
		Actor actor =actorRepositories.save(new Actor("Harrison","Barnes",null,null));
		
		Award award = new Award();
		award.setOrganziation("Academy");
		award.setTitle("Best Actor");
		award.setActor(actor);
		ar.save(award);
		
		Award award2 = new Award();
		award2.setOrganziation("Academy");
		award2.setTitle("Best Supporting Actor");
		award2.setActor(actor2);
		ar.save(award2);
		
		
		ArrayList<Actor> cast= new ArrayList<Actor>();
		cast.add(actor);
		
		movie.setCast(cast);
		movieRepositories.save(movie);
		
		
		
	}
	

}

