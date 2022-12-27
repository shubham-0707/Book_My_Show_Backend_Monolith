package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Adapter.MovieAdapter;
import com.example.BookMyShow.DTO.EntryDTO.MovieEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.MovieNameAndIdObject;
import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;
import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Override
    public MovieResponseDTO addMovie(MovieEntryDTO movieEntryDTO) {
        log.info("Reached till the addMovieFunction");
        MovieResponseDTO movieResponseDTO = null;

       if(movieRepository.existsByName(movieEntryDTO.getName())){
           movieResponseDTO.setName("This movie is already existing");
           return movieResponseDTO;
       }

       log.info("In the function movieDTO " + movieEntryDTO);
       MovieEntity movieEntity = MovieAdapter.DTOtoEntity(movieEntryDTO);
       movieEntity = movieRepository.save(movieEntity);
       movieResponseDTO = MovieAdapter.EntityToDTO(movieEntity);

       return movieResponseDTO;
    }

//    @Override
//    public MovieResponseDTO getMovie(int id) {
//        MovieEntity movieEntity = movieRepository.findById(id).get();
//        MovieResponseDTO movieDTO = MovieAdapter.EntityToDTO(movieEntity);
//        return movieDTO;
//    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id) {
        MovieEntity movieEntity = movieRepository.getById(id);

        MovieNameAndIdObject movieNameAndIdObject = MovieAdapter.convertToThisObject(movieEntity);

        return movieNameAndIdObject;
    }
}
