package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Adapter.TheatreAdapter;
import com.example.BookMyShow.DTO.EntryDTO.TheatreEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;
import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.Model.TheatreSeatEntity;
import com.example.BookMyShow.Repository.TheatreRepository;
import com.example.BookMyShow.Repository.TheatreSeatsRepository;
import com.example.BookMyShow.Service.TheatreService;
import com.example.BookMyShow.enums.SeatType;
import com.example.BookMyShow.enums.TheatreType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatsRepository theatreSeatsRepository;

    @Override
    public TheatreResponseDTO addTheatre(TheatreEntryDTO theatreEntryDTO) {
        TheatreEntity theatreEntity = TheatreAdapter.DTOtoEntity(theatreEntryDTO);

        List<TheatreSeatEntity> seats = createTheatreSeats();

        theatreEntity.setSeats(seats);
        theatreEntity.setShows(null);

        for(TheatreSeatEntity theatreSeatEntity : seats){
            theatreSeatEntity.setTheater(theatreEntity);
        }
        theatreEntity.setType(TheatreType.SINGLE);

        log.info("The theatre Entity is : "+theatreEntity);

        theatreEntity = theatreRepository.save(theatreEntity);

        TheatreResponseDTO theatreResponseDTO = TheatreAdapter.EntityToDTO(theatreEntity);

        return theatreResponseDTO;

    }

    private List<TheatreSeatEntity> createTheatreSeats() {

        List<TheatreSeatEntity> seats = new ArrayList<>();

        seats.add(getTheatreSeats("1A" , 100 , SeatType.CLASSIC));
        seats.add(getTheatreSeats("1B" , 100 , SeatType.CLASSIC));
        seats.add(getTheatreSeats("1C" , 100 , SeatType.CLASSIC));
        seats.add(getTheatreSeats("1D" , 100 , SeatType.CLASSIC));
        seats.add(getTheatreSeats("1E"  , 100 , SeatType.CLASSIC));
        seats.add(getTheatreSeats("2A" , 200 , SeatType.PREMIUM));
        seats.add(getTheatreSeats("2B" , 200 , SeatType.PREMIUM));
        seats.add(getTheatreSeats("2C" , 200  , SeatType.PREMIUM));
        seats.add(getTheatreSeats("2D" , 200 , SeatType.PREMIUM));
        seats.add(getTheatreSeats("2E" , 200 , SeatType.PREMIUM));

        theatreSeatsRepository.saveAll(seats);
        return seats;
    }

    private TheatreSeatEntity getTheatreSeats(String s, int i, SeatType type) {
        return TheatreSeatEntity.builder()
                .seatNumber(s)
                .rate(i)
                .seatType(type)
                .build();
    }

    @Override
    public TheatreResponseDTO getTheatre(int id) {
        TheatreEntity theatreEntity = theatreRepository.findById(id).get();
        TheatreResponseDTO theatreResponseDTO = TheatreAdapter.EntityToDTO(theatreEntity);
        return theatreResponseDTO;
    }
}
