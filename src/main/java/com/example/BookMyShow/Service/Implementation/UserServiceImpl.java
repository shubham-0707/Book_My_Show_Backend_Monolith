package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Adapter.UserAdapter;
import com.example.BookMyShow.DTO.EntryDTO.UserEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;
import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDTO userEntryDTO){
        UserEntity userEntity = UserAdapter.DTOtoEntity(userEntryDTO);
        userRepository.save(userEntity);

    }

    @Override
    public UserResponseDTO getUser(int id){

        UserEntity user = new UserEntity();

        UserEntity userEntity = userRepository.findById(id).get();

        UserResponseDTO userResponseDTO = UserAdapter.EntityToDTO(userEntity);


        return userResponseDTO;


    }

}
