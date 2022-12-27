package com.example.BookMyShow.Controllers;


import com.example.BookMyShow.DTO.EntryDTO.ShowEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.ShowResponseDTO;
import com.example.BookMyShow.Service.Implementation.ShowServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDTO addShow(@RequestBody() ShowEntryDTO showEntryDTO){
        log.info("Here we are...");
        return showService.addShow(showEntryDTO);
    }

}
