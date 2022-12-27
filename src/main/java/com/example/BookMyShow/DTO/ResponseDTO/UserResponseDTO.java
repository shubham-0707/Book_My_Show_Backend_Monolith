package com.example.BookMyShow.DTO.ResponseDTO;

import com.example.BookMyShow.DTO.TicketDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class UserResponseDTO {

    int id;
    String name;

    String mobNo;
    List<TicketDTO> tickets;
}
