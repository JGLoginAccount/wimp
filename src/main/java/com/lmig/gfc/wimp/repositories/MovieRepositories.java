package com.lmig.gfc.wimp.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.wimp.models.Movie;
@Repository
public interface MovieRepositories extends JpaRepository<Movie,Long> {

}