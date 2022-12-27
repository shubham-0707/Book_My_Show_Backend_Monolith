package com.example.BookMyShow.DTO;

import com.example.BookMyShow.DTO.ResponseDTO.ShowResponseDTO;
import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;
import com.sun.istack.NotNull;
import lombok.*;

@Data
@Builder
public class TicketDTO {

    int id;
    String allotted_seats;

    double amount;

    ShowResponseDTO showDTO;

    @NotNull
    UserResponseDTO userDTO;

}
