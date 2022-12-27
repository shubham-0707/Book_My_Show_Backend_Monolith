package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDTO.UserEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;

public interface UserService {
    void addUser(UserEntryDTO userDTO);

    UserResponseDTO getUser(int id);
}
