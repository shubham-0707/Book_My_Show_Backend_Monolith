package com.example.BookMyShow.DTO.EntryDTO;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MovieEntryDTO {
    String name;

    @NotNull
    LocalDate releaseDate;
}
