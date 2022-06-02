package com.example.crudApplication.service.serviceImpl;

import com.example.crudApplication.dto.MovieDetailDto;
import com.example.crudApplication.dto.MovingAddingDto;
import com.example.crudApplication.entity.Movie;
import com.example.crudApplication.exception.CustomServiceException;
import com.example.crudApplication.repository.MovieRepository;
import com.example.crudApplication.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public void addMovie(MovingAddingDto movingAddingDto) {
        Movie movie = new Movie(movingAddingDto.getMovieName(),movingAddingDto.getDescription(),movingAddingDto.getProducer());
        movieRepository.save(movie);
    }

    @Override
    public List<MovieDetailDto> viewMovieDetail() {
        List<Movie> movieList = movieRepository.findAll();
        List<MovieDetailDto> movieDetailDtoList = new ArrayList<>();
        for (Movie movie:movieList) {
            movieDetailDtoList.add(new MovieDetailDto(movie.getId(),movie.getMovieName(),movie.getDescription(), movie.getProducer()));
        }
        return movieDetailDtoList;
    }

    @Override
    public void editMovie(MovieDetailDto movieDetailDto) {
        Movie movie = movieRepository.findById(movieDetailDto.getId()).orElseThrow(() -> new CustomServiceException("movie not found"));
        movie.setMovieName(movieDetailDto.getMovieName());
        movie.setDescription(movieDetailDto.getDescription());
        movie.setProducer(movieDetailDto.getProducer());
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new CustomServiceException("movie not found"));
        movieRepository.delete(movie);
    }
}
