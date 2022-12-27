package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTO.EntryDTO.MovieEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.MovieNameAndIdObject;
import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;
import com.example.BookMyShow.Service.Implementation.MovieServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public MovieResponseDTO addMovie(@RequestBody() MovieEntryDTO movieEntryDTO){
        MovieResponseDTO movieResponseDTO = movieService.addMovie(movieEntryDTO);
        log.info("The movie Response DTO is : "+ movieResponseDTO);
        return movieResponseDTO;
    }

    @GetMapping("/get/{id}")
    public MovieNameAndIdObject getMovieNameAndIdObject(@PathVariable int id){
        MovieNameAndIdObject movieNameAndIdObject = movieService.getNameAndId(id);
        return movieNameAndIdObject;
    }
}
