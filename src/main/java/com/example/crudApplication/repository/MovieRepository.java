package com.example.crudApplication.repository;

import com.example.crudApplication.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query(value = "select * from movie where id=?", nativeQuery = true)
    Movie getMovie(long id);
}

