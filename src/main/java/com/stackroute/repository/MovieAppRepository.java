package com.stackroute.repository;

import com.stackroute.domain.MovieApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieAppRepository extends JpaRepository<MovieApp,String> {

}
