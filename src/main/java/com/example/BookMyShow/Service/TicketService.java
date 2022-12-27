package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.BookTicketRequestDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TicketResponseDTO;

public interface TicketService {
    TicketResponseDTO getTicket(int id);

    TicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO);
}
