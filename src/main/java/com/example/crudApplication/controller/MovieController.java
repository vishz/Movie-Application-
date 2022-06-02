package com.example.crudApplication.controller;

import com.example.crudApplication.dto.MovieDetailDto;
import com.example.crudApplication.dto.MovingAddingDto;
import com.example.crudApplication.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sun.security.mscapi.CPublicKey;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/v1/movie")
@CrossOrigin
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping(value = "/addMovie", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String addingMovie(@RequestBody MovingAddingDto movingAddingDto){
    movieService.addMovie(movingAddingDto);
    return "Successfully added";
    }

    @GetMapping(value = "/addMovie", produces = APPLICATION_JSON_VALUE)
    public List<MovieDetailDto> getMovieDetail(){
        List<MovieDetailDto> movieDetailDtoList = movieService.viewMovieDetail();
        return movieDetailDtoList;
    }

    @PutMapping(value = "/updateMovie", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String updateMovieDetail(@RequestBody MovieDetailDto movieDetailDto){
        movieService.editMovie(movieDetailDto);
        return "Successfully Updated";
    }

    @DeleteMapping(value = "/deleteMovie/{movieId}", produces = APPLICATION_JSON_VALUE)
    public String deleteMovieDetail(@PathVariable("movieId") long movieId){
       movieService.deleteMovie(movieId);
       return "deleted";
    }

}
