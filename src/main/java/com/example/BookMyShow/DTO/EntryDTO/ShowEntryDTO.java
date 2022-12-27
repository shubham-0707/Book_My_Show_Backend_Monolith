package com.example.BookMyShow.DTO.EntryDTO;

import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDTO {
    @NonNull
    LocalDate showDate;

    @NonNull
    LocalTime showTime;

    @NonNull
    MovieResponseDTO movieResponseDTO;

    @NonNull
    TheatreResponseDTO theatreResponseDTO;
}
