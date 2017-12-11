package com.lmig.gfc.wimp.api;

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

import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.repositories.MovieRepositories;

@RestController
@RequestMapping("/api/movies")
public class MovieApiController {

	private MovieRepositories movieRepositories;

	public MovieApiController(MovieRepositories movieRepositories) {
		this.movieRepositories = movieRepositories;

	}

	@GetMapping("")
	public List<Movie> getMovie() {

		return movieRepositories.findAll();

	}

	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Movie createMovie(@RequestBody Movie movie) {
		
		return movieRepositories.save(movie);

	}

	@GetMapping("{id}")
	public Movie getOneMovie(@PathVariable long id) {
		
		return movieRepositories.findOne(id);

	}

	@PutMapping("{id}")
	public Movie UpdateMovie(@RequestBody Movie movie, @PathVariable long id) {
		
		movie.setId(id);
		
		return movieRepositories.save(movie);

	}

	@DeleteMapping("{id}")
	public Movie deleteMovie(@PathVariable long id) {
		
		Movie movie=movieRepositories.findOne(id);
		movieRepositories.delete(id);
		return movie;
		
		

	}
}
