package com.example.BookMyShow.Controllers;


import com.example.BookMyShow.DTO.BookTicketRequestDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TicketResponseDTO;
import com.example.BookMyShow.Service.Implementation.TicketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("get/{id}")
    public TicketResponseDTO getTicketResponseDTO(@PathVariable int id){
        return ticketService.getTicket(id);
    }

    @PostMapping("/add")
    public TicketResponseDTO addTicket(@RequestBody()BookTicketRequestDTO bookTicketRequestDTO){
        return ticketService.bookTicket(bookTicketRequestDTO);
    }

}
