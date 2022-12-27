package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDTO.ShowEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.ShowResponseDTO;

public interface ShowService {
    ShowResponseDTO addShow(ShowEntryDTO showDTO);

    ShowResponseDTO getShow(int id);

}
