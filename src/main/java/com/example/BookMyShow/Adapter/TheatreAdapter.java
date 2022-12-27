package com.example.BookMyShow.Adapter;

import com.example.BookMyShow.DTO.EntryDTO.TheatreEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;
import com.example.BookMyShow.Model.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreAdapter {

    public static TheatreEntity DTOtoEntity(TheatreEntryDTO theatreDTO){
        return TheatreEntity.builder()
                .address(theatreDTO.getAddress())
                .city(theatreDTO.getCity())
                .name(theatreDTO.getName())
                .build();
    }

    public static TheatreResponseDTO EntityToDTO(TheatreEntity theatreEntity){
        return TheatreResponseDTO.builder()
                .id(theatreEntity.getId())
                .name(theatreEntity.getName())
                .city(theatreEntity.getCity())
                .address(theatreEntity.getAddress())
                .theatreType(theatreEntity.getType())
                .build();
    }

}
