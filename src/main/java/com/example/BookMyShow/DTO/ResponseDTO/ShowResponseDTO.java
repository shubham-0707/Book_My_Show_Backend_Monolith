package com.example.BookMyShow.DTO.ResponseDTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponseDTO  {
    int id;
    LocalDate showDate;
    LocalTime showTime;

    MovieResponseDTO movieResponseDTO;
    TheatreResponseDTO theatreResponseDTO;
}
