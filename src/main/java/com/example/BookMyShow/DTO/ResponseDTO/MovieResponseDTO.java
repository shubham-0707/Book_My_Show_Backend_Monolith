package com.example.BookMyShow.DTO.ResponseDTO;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDTO {

    @NotNull
    int id;
    String name;
    LocalDate releaseDate;

    List<ShowResponseDTO> showDTOList;
}
