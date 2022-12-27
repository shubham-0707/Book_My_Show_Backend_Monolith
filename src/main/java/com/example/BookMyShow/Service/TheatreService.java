package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDTO.TheatreEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;

public interface TheatreService {
    TheatreResponseDTO addTheatre(TheatreEntryDTO theatreEntryDTO);
    TheatreResponseDTO getTheatre(int id);
}
