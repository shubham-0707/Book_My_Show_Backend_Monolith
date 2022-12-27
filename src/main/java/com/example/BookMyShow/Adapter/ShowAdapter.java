package com.example.BookMyShow.Adapter;

import com.example.BookMyShow.DTO.EntryDTO.ShowEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.ShowResponseDTO;
import com.example.BookMyShow.Model.ShowEntity;

public class ShowAdapter {

    public static ShowEntity DTOtoEntity(ShowEntryDTO showEntryDTO){
        return ShowEntity.builder()
                .showDate(showEntryDTO.getShowDate())
                .showTime(showEntryDTO.getShowTime())
                .build();
    }

    public static ShowResponseDTO EntityToDTO(ShowEntity showEntity , ShowEntryDTO showEntryDTO){
        return ShowResponseDTO.builder()
                .id(showEntity.getId())
                .showDate(showEntity.getShowDate())
                .showTime(showEntity.getShowTime())
                .movieResponseDTO(showEntryDTO.getMovieResponseDTO())
                .theatreResponseDTO(showEntryDTO.getTheatreResponseDTO())
                .build();
    }
}
