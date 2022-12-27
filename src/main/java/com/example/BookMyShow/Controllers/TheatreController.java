package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTO.EntryDTO.TheatreEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;
import com.example.BookMyShow.Service.Implementation.TheatreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theatre")
@Slf4j
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("/add")
    public TheatreResponseDTO addTheatre(@RequestBody()TheatreEntryDTO theatreEntryDTO){


        TheatreResponseDTO theatreResponseDTO = theatreService.addTheatre(theatreEntryDTO);
        log.info("Theatre is successfully added");
        return theatreResponseDTO;
    }

}
