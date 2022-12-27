package com.example.BookMyShow.DTO.ResponseDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieNameAndIdObject {
    int id;
    String name;
}
