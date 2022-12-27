package com.example.BookMyShow.DTO;

import com.example.BookMyShow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookTicketRequestDTO {
    int id;
    int showId;

    SeatType seatType;

    Set<String> requestedSeats;
}
