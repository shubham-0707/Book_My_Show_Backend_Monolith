package com.example.BookMyShow.DTO.ResponseDTO;

import com.example.BookMyShow.enums.TheatreType;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponseDTO {

    @NotNull
    int id;
    String name;
    String address;
    String city;

    TheatreType theatreType;
}
