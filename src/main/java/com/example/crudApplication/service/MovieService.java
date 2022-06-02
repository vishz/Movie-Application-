package com.example.crudApplication.service;

import com.example.crudApplication.dto.MovieDetailDto;
import com.example.crudApplication.dto.MovingAddingDto;

import java.util.List;

public interface MovieService {

    void addMovie(MovingAddingDto movingAddingDto);
    List<MovieDetailDto> viewMovieDetail();
    void editMovie(MovieDetailDto movieDetailDto);
    void deleteMovie(Long id);
}
