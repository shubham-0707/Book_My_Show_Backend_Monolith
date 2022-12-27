package com.example.BookMyShow.Adapter;

import com.example.BookMyShow.DTO.ResponseDTO.TicketResponseDTO;
import com.example.BookMyShow.Model.TicketEntity;

public class TicketAdapter {
    public static TicketResponseDTO EntityToDTO(TicketEntity ticketEntity){
        return TicketResponseDTO.builder()
                .id(ticketEntity.getId())
                .amount(ticketEntity.getAmount())
                .allotted_seats(ticketEntity.getAllottedSeats())
                .build();
    }
}
