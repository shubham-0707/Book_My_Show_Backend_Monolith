package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Adapter.ShowAdapter;
import com.example.BookMyShow.DTO.EntryDTO.ShowEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.ShowResponseDTO;
import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.ShowSeatsRepository;
import com.example.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;


    public ShowResponseDTO addShow(ShowEntryDTO showEntryDTO){
        ShowEntity showEntity = ShowAdapter.DTOtoEntity(showEntryDTO);

        MovieEntity movieEntity = movieRepository.findById(showEntryDTO.getMovieResponseDTO().getId()).get();
        TheatreEntity theatreEntity = theatreRepository.findById(showEntryDTO.getTheatreResponseDTO().getId()).get();
        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theatreEntity);

        showEntity = showRepository.save(showEntity);
        generateShowEntitySeats(theatreEntity.getSeats(),showEntity);

        ShowResponseDTO showResponseDto = ShowAdapter.EntityToDTO(showEntity,showEntryDTO);

        return showResponseDto;
        
        
    }

    private void generateShowEntitySeats(List<TheatreSeatEntity> seats, ShowEntity showEntity) {

        List<ShowSeatsEntity> showSeatsEntities = new ArrayList<>();
        for(TheatreSeatEntity tse : seats){
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder()
                    .seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType())
                    .rate(tse.getRate())
                    .build();

            showSeatsEntities.add(showSeatsEntity);
        }

        for(ShowSeatsEntity showSeatsEntity : showSeatsEntities){
            showSeatsEntity.setShow(showEntity);
        }

        showSeatsRepository.saveAll(showSeatsEntities);
        showEntity.setSeats(showSeatsEntities);
    }



}
