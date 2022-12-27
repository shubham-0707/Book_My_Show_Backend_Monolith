package com.example.BookMyShow.Adapter;

import com.example.BookMyShow.DTO.EntryDTO.MovieEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.MovieNameAndIdObject;
import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;
import com.example.BookMyShow.Model.MovieEntity;

public class MovieAdapter {

    public static MovieEntity DTOtoEntity(MovieEntryDTO movieEntryDTO){
        return MovieEntity.builder()
                .name(movieEntryDTO.getName())
                .releaseDate(movieEntryDTO.getReleaseDate()).build();
    }

    public static MovieResponseDTO EntityToDTO(MovieEntity movieEntity){
        return MovieResponseDTO.builder()
                .name(movieEntity.getName())
                .releaseDate(movieEntity.getReleaseDate())
                .id(movieEntity.getId())
                .build();
    }

    public static MovieNameAndIdObject convertToThisObject(MovieEntity movieEntity){
        return MovieNameAndIdObject.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .build();
    }

}
