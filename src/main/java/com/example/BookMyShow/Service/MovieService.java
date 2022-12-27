package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDTO.MovieEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.MovieNameAndIdObject;
import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;


public interface MovieService {
    MovieResponseDTO addMovie(MovieEntryDTO movieDTO);

    //MovieResponseDTO getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);
}
