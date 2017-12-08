package com.lmig.gfc.wimp.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.repositories.ActorRepositories;
import com.lmig.gfc.wimp.repositories.AwardReposirtory;

@RestController
@RequestMapping("/api/actors/{actorId}/awards")
public class ActorAwardApi {

	ActorRepositories ar;
	AwardReposirtory awardR;

	public ActorAwardApi(ActorRepositories ar, AwardReposirtory awardR) {
		this.ar = ar;
		this.awardR = awardR;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Actor create(@RequestBody Award award, @PathVariable Long actorId) {

		Actor actor = ar.findOne(actorId);
		actor.getAwards().add(award);
		award.setActor(actor);
		awardR.save(award);
		return actor;
	}

}
