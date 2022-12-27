package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Adapter.ShowAdapter;
import com.example.BookMyShow.Adapter.TicketAdapter;
import com.example.BookMyShow.DTO.BookTicketRequestDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TicketResponseDTO;
import com.example.BookMyShow.Model.ShowEntity;
import com.example.BookMyShow.Model.ShowSeatsEntity;
import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TicketRepository;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;


    @Override
    public TicketResponseDTO getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();
        TicketResponseDTO ticketResponseDTO = TicketAdapter.EntityToDTO(ticketEntity);
        return ticketResponseDTO;
    }

    @Override
    public TicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO) {
        UserEntity userEntity = userRepository.findById(bookTicketRequestDTO.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDTO.getId()).get();

        Set<String> requestedSeats = bookTicketRequestDTO.getRequestedSeats();
        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getSeats();

        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat : showSeatsEntityList){
            if(!seat.isBooked()&& seat.getSeatType().equals(bookTicketRequestDTO.getSeatType()) && requestedSeats.contains(seat.getSeatNumber())){
                bookedSeats.add(seat);
            }
        }

        if(bookedSeats.size()!=requestedSeats.size()){
            throw new Error("All seats not available");
        }

        TicketEntity ticketEntity = TicketEntity.builder()
                .user(userEntity)
                .show(showEntity)
                .seats(bookedSeats)
                .build();

        double amount = 0;

        for(ShowSeatsEntity showSeatsEntity : bookedSeats){
            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setBookedAt(new Date());

        ticketEntity.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);

        showEntity.getTickets().add(ticketEntity);
        userEntity.getTicketEntities().add(ticketEntity);

        ticketEntity = ticketRepository.save(ticketEntity);


        return TicketAdapter.EntityToDTO(ticketEntity);
    }

    private String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats) {

        String str = "";

        for(ShowSeatsEntity showSeatsEntity : bookedSeats){
            str = str + showSeatsEntity.getSeatNumber()+" ";
        }
        return str;
    }
}
