package com.lmig.gfc.wimp.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.ActorRepositories;
import com.lmig.gfc.wimp.repositories.MovieRepositories;

@Configuration
public class SeedData {
	
	public SeedData(ActorRepositories actorRepositories, MovieRepositories movieRepositories) {
		
		 
		
		actorRepositories.save(new Actor("Bob","Hope",null,null));
		
		actorRepositories.save(new Actor("Harrison","Hope",12L,null));
		
		actorRepositories.save(new Actor("Harrison","Barnes",null,null));
		
		movieRepositories.save(new Movie("The Big Red One",null,121L,"Miramax"));
	
		
	}
	

}

