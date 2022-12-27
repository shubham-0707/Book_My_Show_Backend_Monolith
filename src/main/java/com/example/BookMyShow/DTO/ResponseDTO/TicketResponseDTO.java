package com.example.BookMyShow.DTO.ResponseDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDTO {

    int id;
    String allotted_seats;

    double amount;

}
